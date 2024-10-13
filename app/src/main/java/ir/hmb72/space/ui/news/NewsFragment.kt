package ir.hmb72.space.ui.news

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import dagger.hilt.android.AndroidEntryPoint
import ir.hmb72.space.R
import ir.hmb72.space.data.model.home.PlanetModel
import ir.hmb72.space.databinding.FragmentNewsBinding
import ir.hmb72.space.ui.home.HomeFragmentDirections
import ir.hmb72.space.utils.CenterZoomLinearLayoutManager
import ir.hmb72.space.utils.backToPreviousFragment
import ir.hmb72.space.utils.setupRecyclerView
import ir.hmb72.space.viewmodel.NewsViewModel
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : Fragment() {
    //Binding
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var adapterNews: AdapterNews

    private val viewModel: NewsViewModel by viewModels()

    //Other
    private var recyclerState: Parcelable? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Back
        binding.backBtn.backToPreviousFragment()
        //InitViews
        loadDataNews()
    }

    private fun initRecyclerNews(data: List<PlanetModel>) {
        binding.apply {
            adapterNews.setData(data)
            //Custom layout manager
            listNews.setupRecyclerView(LinearLayoutManager(requireContext()), adapterNews)

            //Auto Scroll
            listNews.layoutManager?.onRestoreInstanceState(recyclerState)

            //Click
            adapterNews.setOnItemClickListener {
                //Save state
                recyclerState = listNews.layoutManager?.onSaveInstanceState()
                val directions = NewsFragmentDirections.actionToDetailNewsFragment(it)
                findNavController().navigate(directions)
            }
        }
    }

    private fun loadDataNews() {
        viewModel.getListNews()
        viewModel.newsList.observe(viewLifecycleOwner) {
            initRecyclerNews(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}