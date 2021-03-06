package com.example.android.databinding.twowaysample.ui.test

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.*
import com.test.databinding_twoways.R

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/11/22 0022
 *  @pkn    : com.example.android.databinding.twowaysample.ui.test
 *  @desc   :
 */
object BindAdapters {


    @BindingAdapter("numberOfSets")
    @JvmStatic
    fun setNumberOfSets(view: EditText, value: String) {
        view.setText(value)
    }

    @InverseBindingAdapter(attribute = "numberOfSets", event = "numberOfSetsAttrChanged")
    @JvmStatic
    fun getNumberOfSets(view: EditText): String {
        return view.text.toString()
    }

    @BindingAdapter("numberOfSetsAttrChanged", requireAll = false)
    @JvmStatic
    fun setNumberOfSetsListener(view: EditText, listener: InverseBindingListener?) {
        Log.e("TestActivity_Two", "__" + listener.toString())

        view.onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
            val textView = focusedView as TextView
            if (hasFocus) {
                // Delete contents of the EditText if the focus entered.
                textView.text = ""
            } else {
                Log.e("TestActivityAttrChanged", "setNumberOfSetsListener")
                // If the focus left, update the listener
                listener?.onChange()
            }
        }
    }

    /**
     * Hides keyboard when the [EditText] is focused.
     *
     * Note that there can only be one [TextView.OnEditorActionListener] on each [EditText] and
     * this [BindingAdapter] sets it.
     */
    @BindingAdapter("hideKeyboardOnInputDone")
    @JvmStatic
    fun hideKeyboardOnInputDone(view: EditText, enabled: Boolean) {
        if (!enabled) return
        val listener = TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                view.clearFocus()
                val inputMethodManager =
                    view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            }
            false
        }
        view.setOnEditorActionListener(listener)
    }

    @BindingAdapter("setProgress")
    @JvmStatic
    fun setProgress(view: SeekBar, value: Int) {
        if (value != getProgress(view)) {
            view.setProgress(value)
        }
    }

    @InverseBindingAdapter(attribute = "setProgress", event = "setProgressAttrChanged")
    @JvmStatic
    fun getProgress(view: SeekBar): Int {
        return view.progress
    }

    @BindingAdapter("setProgressAttrChanged", requireAll = false)
    @JvmStatic
    fun setProgressSetsListener(view: SeekBar, listener: InverseBindingListener?) {
        view.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                listener?.onChange()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }


    @BindingAdapter("numberOfSets_alternative")
    @JvmStatic
    fun setNumberOfSets_alternative(view: EditText, value: Array<Int>) {
        view.setText(
            String.format(
                view.resources.getString(
                    R.string.sets_format,
                    value[0] + 1,
                    value[1]
                )
            )
        )
    }

    @InverseBindingAdapter(attribute = "numberOfSets_alternative")
    @JvmStatic
    fun getNumberOfSets_alternative(editText: EditText): Array<Int> {
        if (editText.text.isEmpty()) {
            return arrayOf(0, 0)
        }

        return try {
            arrayOf(0, editText.text.toString().toInt()) // First item is not passed
        } catch (e: NumberFormatException) {
            arrayOf(0, 0)
        }
    }

}

/**
 *
 * @InverseBindingMethods
 * 函数和对象关联
 */
object BindMethods {

    @InverseMethod("convertStringToInt")
    @JvmStatic
    fun convertIntToString(value: Int): String {
        return value.toString()
    }

    @JvmStatic
    fun convertStringToInt(value: String): Int {
        try {
            return Integer.parseInt(value);
        } catch (ex: NumberFormatException) {
            return -1;
        }
    }
}

/**
 * 格式转换
 */
object BindingConverters {

    @BindingConversion
    @JvmStatic
    fun intToString(value: Int): String? {
        return value.toString()
    }
}