package ir.hmb72.space.ui.news_detail

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.text.HtmlCompat
import androidx.navigation.fragment.navArgs
import ir.hmb72.space.R
import ir.hmb72.space.databinding.FragmentNewsBinding
import ir.hmb72.space.databinding.FragmentNewsDetailBinding
import ir.hmb72.space.utils.backToPreviousFragment
import ir.hmb72.space.utils.goNextLine
import ir.hmb72.space.utils.justifyMode


class NewsDetailFragment : Fragment() {
    //Binding
    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    //Other
    private val arg: NewsDetailFragmentArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNewsDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navData = arg.detailNews
        //InitViews
        binding.apply {

            //Back
            backBtn.backToPreviousFragment()
            //Title
            nameNews.text = navData.name
            //Content

            contentNews.text = navData.description!!.goNextLine()
            contentNews.justifyMode()

            //----------------------------------
            /*  Going to the next line when there is a dot but
                  when there are decimal numbers and English words in the text caused a mess.*/
            /*  val des = navData.description
              val formattedText = des?.replace("." , ".<br>") // go next line
              val htmlText = "<div dir=\"auto\">$formattedText</div>" // english words
             contentNews.text =  HtmlCompat.fromHtml(htmlText, HtmlCompat.FROM_HTML_MODE_LEGACY)*/
            //----------------------------------
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}