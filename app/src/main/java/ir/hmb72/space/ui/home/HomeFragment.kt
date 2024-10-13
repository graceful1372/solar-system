package ir.hmb72.space.ui.home

import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import ir.hmb72.space.databinding.FragmentHomeBinding
import ir.hmb72.space.data.model.home.CategoryModel
import ir.hmb72.space.data.model.home.PlanetModel
import ir.hmb72.space.data.offline_data.home.HomeList
import ir.hmb72.space.ui.home.adapter.AdapterCategory
import ir.hmb72.space.ui.home.adapter.AdapterMainItem
import ir.hmb72.space.utils.CenterZoomLinearLayoutManager
import ir.hmb72.space.utils.setupRecyclerView
import ir.hmb72.space.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import ir.hmb72.space.R
import ir.hmb72.space.utils.justifyMode
import ir.hmb72.space.viewmodel.NewsViewModel
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class HomeFragment : Fragment() {
    //Binding
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var homeList: HomeList

    @Inject
    lateinit var adapterMainItem: AdapterMainItem

    @Inject
    lateinit var adapterCategory: AdapterCategory

    //View model
    private val viewModel: HomeViewModel by viewModels()
    private val viewModelNews: NewsViewModel by viewModels()

    //Other
    private var recyclerViewCategoryState: Parcelable? = null
    private var recyclerViewMainState: Parcelable? = null
    private var saveDataRecyclerviewMain: String? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //InitViews
        binding.apply {

            //Go to news list
            showAllTxt.setOnClickListener {
                val directions = HomeFragmentDirections.actionToNewsFragment()
                findNavController().navigate(directions)
            }
            //Go to about
            menuBtn.setOnClickListener {
                if (goAboutMe.isVisible){
                    goAboutMe.visibility = View.GONE

                }else{
                    goAboutMe.visibility = View.VISIBLE
                }

            }
            goAboutMe.setOnClickListener{
                findNavController().navigate(R.id.aboutMeFragment)
            }

        }
        //Check state recyclerview
        if (saveDataRecyclerviewMain != null) {
            viewModel.getListDataHome(saveDataRecyclerviewMain!!)
        } else {
            defaultAllList()
        }

        //List's
        initRecyclerCategory(homeList.listCategory)
        loadDataMainRecycler()
        loadDataNews()

    }

    private fun initRecyclerCategory(data: List<CategoryModel>) {
        binding.apply {
            adapterCategory.setData(data)

            listCategory.setupRecyclerView(
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true),
                adapterCategory
            )
            //Auto Scroll
            listCategory.layoutManager?.onRestoreInstanceState(recyclerViewCategoryState)
            //Click
            adapterCategory.setOnItemClickListener {
                viewModel.getListDataHome(it)
                //Save state
                saveDataRecyclerviewMain = it
                recyclerViewCategoryState = listCategory.layoutManager?.onSaveInstanceState()
            }


        }


    }

    private fun initRecyclerMainItem(data: List<PlanetModel>) {

        binding.apply {
            adapterMainItem.setData(data)
            //Custom layout manager
            val layoutManager = CenterZoomLinearLayoutManager(requireContext(), 0.4f, 0.15f)
            listMain.setupRecyclerView(layoutManager, adapterMainItem)
            if (listMain.onFlingListener == null) {
                val pagerSnapHelper = PagerSnapHelper()
                pagerSnapHelper.attachToRecyclerView(listMain)
            }
            //Auto Scroll
            listMain.layoutManager?.onRestoreInstanceState(recyclerViewMainState)

            //Click
            adapterMainItem.setOnItemClickListener {
                //Save state
                recyclerViewMainState = listMain.layoutManager?.onSaveInstanceState()
                val directions = HomeFragmentDirections.actionHomeFragmentToIntroductionFragment(it)
                findNavController().navigate(directions)
            }
        }


    }

    private fun loadDataMainRecycler() {
        viewModel.homeList.observe(viewLifecycleOwner) {
            initRecyclerMainItem(it)
        }
    }

    private fun defaultAllList() {
        viewModel.getAllListDataHome()
        viewModel.homeList.observe(viewLifecycleOwner) {
            initRecyclerMainItem(it)
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun loadDataNews() {
        viewModelNews.getListNews()
        viewModelNews.newsList.observe(viewLifecycleOwner) { list ->
            val randomNumber = (1..10).random()
            binding.apply {
                //Find element
                val elementSelected = list.find { it.id == randomNumber }
                //Set Element
                elementSelected?.let {
                    titleNews.text = it.name
                    contentNews.text = it.description
                    contentNews.justifyMode()

                    layNews.setOnClickListener {
                        val directions = HomeFragmentDirections.actionToDetailNewsFragment(elementSelected)
                        findNavController().navigate(directions)
                    }

                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}