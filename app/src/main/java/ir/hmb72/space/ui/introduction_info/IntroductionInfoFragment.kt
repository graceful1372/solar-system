package ir.hmb72.space.ui.introduction_info

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import ir.hmb72.space.databinding.FragmentIntroductionInfoBinding
import ir.hmb72.space.utils.backToPreviousFragment
import ir.hmb72.space.utils.goNextLine
import ir.hmb72.space.utils.justifyMode

@AndroidEntryPoint
class IntroductionInfoFragment : Fragment() {
    //Binding
    private var _binding:FragmentIntroductionInfoBinding?= null
    private val binding get()= _binding!!

    //Other
    private val args  :IntroductionInfoFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {
        _binding = FragmentIntroductionInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val itemArgs = args.description
        //InitViews
        binding.apply {
            //Back
            backBtn.backToPreviousFragment()
            //Image
            Glide.with(requireContext()).load(itemArgs.imageUrl).into(imgIntroduce)
            //Description txt
            descriptionTxt.text= itemArgs.description?.goNextLine() ?: ""
            descriptionTxt.justifyMode()
//            //Justify mode
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//                descriptionTxt.justificationMode = JUSTIFICATION_MODE_INTER_WORD
//            }

        }


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}