package com.test.databinding_twoways.ui;

import java.lang.System;

/**
 * A collection of [BindingAdapter]s for different UI-related tasks.
 *
 * In Kotlin you can write the Binding Adapters in the traditional way:
 *
 * ```
 * @BindingAdapter("property")
 * @JvmStatic fun propertyMethod(view: ViewClass, parameter1: Param1, parameter2: Param2...)
 * ```
 *
 * Or using extension functions:
 *
 * ```
 * @BindingAdapter("property")
 * @JvmStatic fun ViewClass.propertyMethod(parameter1: Param1, parameter2: Param2...)
 * ```
 *
 * See [EditText.clearTextOnFocus].
 *
 * Also, keep in mind that @JvmStatic is only necessary if you define the methods inside a class or
 * object. Consider moving the Binding Adapters to the top level of the file.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\t\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0014\u0010\f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0014\u0010\u000f\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0014\u0010\u0010\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0014\u0010\u0011\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J\u001c\u0010\u0013\u001a\u00020\u0004*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/test/databinding_twoways/ui/BindingAdapters;", "", "()V", "clearOnFocusAndDispatch", "", "view", "Landroid/widget/EditText;", "listener", "Landroid/view/View$OnFocusChangeListener;", "clearTextOnFocus", "enabled", "", "goneUnless", "Landroid/view/View;", "visible", "hideKeyboardOnInputDone", "invisibleUnless", "loseFocusWhen", "condition", "updateProgress", "Landroid/widget/ProgressBar;", "max", "", "progress", "databinding_twoways_debug"})
public final class BindingAdapters {
    public static final com.test.databinding_twoways.ui.BindingAdapters INSTANCE = null;
    
    /**
     * When defined in an [EditText], this [BindingAdapter] will clear the text on focus and
     * set the previous value if the user doesn't enter one. When the focus leaves, it calls
     * the listener that was passed as an argument.
     *
     * Note that `android:selectAllOnFocus="true"` does something similar but not exactly the same.
     *
     * @see [clearTextOnFocus] for a version without a listener.
     */
    @androidx.databinding.BindingAdapter(value = {"clearOnFocusAndDispatch"})
    public static final void clearOnFocusAndDispatch(@org.jetbrains.annotations.NotNull()
    android.widget.EditText view, @org.jetbrains.annotations.Nullable()
    android.view.View.OnFocusChangeListener listener) {
    }
    
    /**
     * Clears the text on focus.
     *
     * This method is using extension functions. It's equivalent to:
     * ```
     * @JvmStatic fun clearTextOnFocus(view: EditText, enabled: Boolean)...
     * ```
     */
    @androidx.databinding.BindingAdapter(value = {"clearTextOnFocus"})
    public static final void clearTextOnFocus(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$clearTextOnFocus, boolean enabled) {
    }
    
    /**
     * Hides keyboard when the [EditText] is focused.
     *
     * Note that there can only be one [TextView.OnEditorActionListener] on each [EditText] and
     * this [BindingAdapter] sets it.
     */
    @androidx.databinding.BindingAdapter(value = {"hideKeyboardOnInputDone"})
    public static final void hideKeyboardOnInputDone(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$hideKeyboardOnInputDone, boolean enabled) {
    }
    
    /**
     * Makes the View [View.INVISIBLE] unless the condition is met.
     */
    @kotlin.Suppress(names = {"unused"})
    @androidx.databinding.BindingAdapter(value = {"invisibleUnless"})
    public static final void invisibleUnless(@org.jetbrains.annotations.NotNull()
    android.view.View $this$invisibleUnless, boolean visible) {
    }
    
    /**
     * Makes the View [View.GONE] unless the condition is met.
     */
    @kotlin.Suppress(names = {"unused"})
    @androidx.databinding.BindingAdapter(value = {"goneUnless"})
    public static final void goneUnless(@org.jetbrains.annotations.NotNull()
    android.view.View $this$goneUnless, boolean visible) {
    }
    
    /**
     * In [ProgressBar], [ProgressBar.setMax] must be called before [ProgressBar.setProgress].
     * By grouping both attributes in a BindingAdapter we can make sure the order is met.
     *
     * Also, this showcases how to deal with multiple API levels.
     */
    @androidx.databinding.BindingAdapter(requireAll = true, value = {"android:max", "android:progress"})
    public static final void updateProgress(@org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar $this$updateProgress, int max, int progress) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"loseFocusWhen"})
    public static final void loseFocusWhen(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$loseFocusWhen, boolean condition) {
    }
    
    private BindingAdapters() {
        super();
    }
}