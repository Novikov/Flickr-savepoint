package com.umbrella.flickr.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.umbrella.flickr.databinding.ViewInputTextViewBinding

class InputTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding =
        ViewInputTextViewBinding.inflate(LayoutInflater.from(context), this, true)

    var text
        get() = binding.inputText.text.toString()
        set(value) {
            binding.inputText.setText(value)
        }
}
