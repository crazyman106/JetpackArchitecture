package com.test.databinding_twoways.ui

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.InverseMethod
import com.test.databinding_twoways.R

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/11/19 0019
 *  @pkn    : com.test.databinding_twoways.ui
 *  @desc   :
 */


/**
 * The @={} notation, which importantly includes the "=" sign, receives data changes to the property and listen to user updates at the same time
 *
 * The [EditText] that controls the number of sets is using two-way Data Binding. Applying a
 * 2-way expression to the `android:text` attribute of the EditText triggers an update on every
 * keystroke. This is an alternative implementation that uses a [View.OnFocusChangeListener]
 * instead.
 *
 * `numberOfSetsAttrChanged` creates a listener that triggers when the focus is lost
 *
 * `hideKeyboardOnInputDone` (in a different file) will clear focus when the `Done` action on
 * the keyboard is dispatched, triggering `numberOfSetsAttrChanged`.
 */
object NumberOfSetsBindingAdapters {
    /**
     * Needs to be used with [NumberOfSetsConverters.setArrayToString].
     */

    @BindingAdapter("setNumberOfSets")
    @JvmStatic
    fun EditText.setNumberOfSets(value: String) {
        this.setText(value)
    }

    /**
     * Called when the [InverseBindingListener] of the `numberOfSetsAttrChanged` binding adapter
     * is notified of a change.
     *
     * Used with the inverse method of [NumberOfSetsConverters.setArrayToString], which is
     * [NumberOfSetsConverters.stringToSetArray].
     */
    @InverseBindingAdapter(attribute = "numberOfSets")
    @JvmStatic
    fun EditText.setNumberOfSets(): String {
        return text.toString()
    }

    /**
     * That this Binding Adapter is not defined in the XML. "AttrChanged" is a special
     * suffix that lets you manage changes in the value, using two-way Data Binding.
     *
     * Note that setting a [View.OnFocusChangeListener] overrides other listeners that might be set
     * with `android:onFocusChangeListener`. Consider supporting both in the same binding adapter
     * with `requireAll = false`. See [android.databinding.adapters.CompoundButtonBindingAdapter]
     * for an example.
     */
    @BindingAdapter("numberOfSetsAttrChanged")
    @JvmStatic
    fun EditText.setListener(listener: InverseBindingListener) {
        this.onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
            val textView = focusedView as TextView
            if (hasFocus) {
                // Delete contents of the EditText if the focus entered.
                textView.text = ""
            } else {
                // If the focus left, update the listener
                listener.onChange()
            }
        }
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

object NumberOfSetsConverters {
    /**
     * Used with `numberOfSets` to convert from array to String.
     */
    @InverseMethod("stringToSetArray")
    @JvmStatic
    fun setArrayToString(context: Context, value: Array<Int>): String {
        return context.getString(R.string.sets_format, value[0] + 1, value[1])
    }

    /**
     * This is the Inverse Method used in `numberOfSets`, to convert from String to array.
     *
     * Note that Context is passed
     */
    @JvmStatic
    fun stringToSetArray(unused: Context, value: String): Array<Int> {
        // Converts String to long
        if (value.isEmpty()) {
            return arrayOf(0, 0)
        }

        return try {
            arrayOf(0, value.toInt()) // First item is not passed
        } catch (e: NumberFormatException) {
            arrayOf(0, 0)
        }

    }
}