package com.umbrella.flickr.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.umbrella.flickr.R
import com.umbrella.flickr.databinding.ViewInputTextViewBinding
import com.umbrella.flickr.utils.logErrorIfDebug

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

    var hint
        get() = binding.inputText.hint.toString()
        set(value) {
            binding.inputText.hint = value
        }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.InputTextViewWithHint).apply {
            try {
                hint = getString(R.styleable.InputTextViewWithHint_android_hint).orEmpty()
            } catch (ex: Exception) {
                logErrorIfDebug(ex)
            } finally {
                recycle()
            }
        }
    }
}
