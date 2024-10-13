package ir.hmb72.space.ui.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import ir.hmb72.space.R
import ir.hmb72.space.databinding.FragmentAboutMeBinding
import ir.hmb72.space.utils.backToPreviousFragment
import ir.hmb72.space.utils.goNextLine


class AboutMeFragment : Fragment() {
    //Binding
    private var _binding: FragmentAboutMeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAboutMeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //InitViews
        binding.apply {
            //Back
            backBtn.backToPreviousFragment()
            //Set text
            setTextAbout()
            //Go gmail
            gmailTxt.setOnClickListener {
                goTOGmail()
            }
            linkedinTxt.setOnClickListener{
                goToLinkedin()
            }
        }



    }

    private fun setTextAbout() {


        //set <br> in text
        val aboutText = getString(R.string.about_me_content)
//        val formattedText = aboutText.replace("/", ".<br>") // go next line
//        val removeSlash = formattedText.replace("/", "")
//        val htmlText = HtmlCompat.fromHtml(removeSlash, HtmlCompat.FROM_HTML_MODE_LEGACY)
        val htmlText = aboutText.goNextLine()
        //Change size
        val start = htmlText.indexOf("برازنده")
        val end = start + "برازنده".length
        val builder = SpannableStringBuilder(htmlText)
        builder.setSpan(AbsoluteSizeSpan(20, true), start, end, SpannableString.SPAN_INCLUSIVE_INCLUSIVE)
        binding.aboutContent.text = builder

    }

    private fun goTOGmail() {
        val gmail = "graceful1372@gmail.com"
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(gmail))
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null){
            startActivity(intent)
        }
    }

    private fun goToLinkedin() {
        val url = "https://www.linkedin.com/in/hossein-moghadasi-barazandeh-a70687178/"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}