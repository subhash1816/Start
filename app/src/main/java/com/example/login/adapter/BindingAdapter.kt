package com.example.login.adapter

import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["htmlText"], requireAll = false)
fun setHtmlText(textView: TextView, text: String?) {
    text?.let {
        textView.text = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
