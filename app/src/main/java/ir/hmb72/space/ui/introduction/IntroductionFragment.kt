package ir.hmb72.space.ui.introduction

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import ir.hmb72.space.data.model.home.PlanetModel
import ir.hmb72.space.databinding.FragmentIntroductionBinding
import dagger.hilt.android.AndroidEntryPoint
import ir.hmb72.space.utils.backToPreviousFragment
import ir.hmb72.space.utils.hide
import ir.hmb72.space.utils.practicalSymbol

@AndroidEntryPoint
class IntroductionFragment : Fragment() {
    //Binding
    private var _binding: FragmentIntroductionBinding? = null
    private val binding get() = _binding!!

    //Other
    private val args: IntroductionFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentIntroductionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //args
        val itemInfo = args.infoItem


        //InitViews
        binding.apply {
            //Back
            backBtn.backToPreviousFragment()
            //Information
            tabInfo.setOnClickListener {
                val directions = IntroductionFragmentDirections.actionToDescription(itemInfo)
                findNavController().navigate(directions)
            }

            //LoadData
            loadData(itemInfo)


        }
    }

    private fun loadData(info: PlanetModel) {
        binding.apply {
            //Image
            Glide.with(requireContext()).load(info.imageUrl).into(imgIntroduce)
            //Name
            nameIntroduce.text = info.name
            //Information
            if (info.distanceFromSun == null) {
                infoOneTitle.hide()
                infoOneContent.hide()
                infoTwoTitle.hide()
                infoTwoContent.hide()

            } else {
                infoOneTitle.text = "فاصله از خورشید"
                infoOneContent.text = info.distanceFromSun.practicalSymbol()

                infoTwoTitle.text = "اندازه"
                infoTwoContent.text = info.size?.practicalSymbol() ?: ""
            }


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}