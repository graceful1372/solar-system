package ir.hmb72.space.utils

import android.graphics.text.LineBreaker
import android.os.Build
import android.text.SpannableString
import android.text.Spanned
import android.text.style.SuperscriptSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.text.HtmlCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.setupRecyclerView(myLayoutManager: RecyclerView.LayoutManager, myAdapter: RecyclerView.Adapter<*>) {
    this.apply {
        layoutManager = myLayoutManager
        setHasFixedSize(true)
        adapter = myAdapter

    }
}

fun Double.practicalSymbol(): SpannableString {

    val number = this.toLong().toString()
    //Create Decimal point
    val numberDecimalPoint = number.substring(0, 1) + "." + number.substring(1)
    //Count length decimal part
    val decimalPart = numberDecimalPoint.substringAfter(".")
    val lengthOfDecimal = decimalPart.length
    //Remove zero end
    val removeZero = removeTrailingZeros(number)
    //Since we have decimals in two-digit numbers, we must also calculate its space
    val spaceOfPoint = 1
    //Check the number is single or couple
    if (removeZero.length != 1) {
        val removeZeroDecimal = removeZero.substring(0, 1) + "." + removeZero.substring(1)
        val createNumber = "$removeZeroDecimal × 10$lengthOfDecimal km"
        //Check the position for add Spannable
        //More-digit number so , we have decimal point
        val positionCharacterStart = removeZero.length + 5 + spaceOfPoint
        val positionCharacterEnd = removeZero.length + 7 + spaceOfPoint
        val spannable = SpannableString(createNumber)
        spannable.setSpan(
            SuperscriptSpan(),
            positionCharacterStart,
            positionCharacterEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannable
    } else {
        val createNumber = "$removeZero × 10$lengthOfDecimal km"
        //One-digit number so , not have decimal point .
        val positionCharacterStart = removeZero.length + 5
        val positionCharacterEnd = removeZero.length + 7 + spaceOfPoint
        val spannable = SpannableString(createNumber)
        spannable.setSpan(
            SuperscriptSpan(),
            positionCharacterStart,
            positionCharacterEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannable
    }

}

fun removeTrailingZeros(number: String): String {
    var num = number.trimEnd('0')
    if (num.endsWith('.')) {
        num = num.dropLast(1)
    }
    return num
}

fun View.backToPreviousFragment(){
    this.setOnClickListener { findNavController().navigateUp() }
}

fun View.hide(){
    this.visibility = View.GONE
}

@RequiresApi(Build.VERSION_CODES.Q)
fun TextView.justifyMode(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        this.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
    }

}

fun String.goNextLine():Spanned{
    val formattedText = this.replace("/", ".<br>") // go next line
    val removeSlash = formattedText.replace("/", "")
    return HtmlCompat.fromHtml(removeSlash, HtmlCompat.FROM_HTML_MODE_LEGACY)
}


