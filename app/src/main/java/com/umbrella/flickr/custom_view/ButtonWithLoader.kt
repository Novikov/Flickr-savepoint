package com.umbrella.flickr.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.umbrella.flickr.databinding.ViewButtonWithLoaderBinding

class ButtonWithLoader @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding =
        ViewButtonWithLoaderBinding.inflate(LayoutInflater.from(context), this, true)

    var text
        get() = binding.button.text.toString()
        set(value) {
            binding.button.text = value
        }
}
