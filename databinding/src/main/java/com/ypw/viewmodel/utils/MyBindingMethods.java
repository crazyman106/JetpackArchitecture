package com.ypw.viewmodel.utils;

import android.widget.ImageView;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/11/6 0006
 * @pkn : com.ypw.viewmodel.utils
 * @desc :/**
 * `app:srcCompat` is an attribute used by the support library to integrate vector drawables.
 * This BindingMethod binds the attribute to the setImageDrawable method in the ImageView class.
 * 这个BindingMethod将`app:srcCompat`属性和ImageView中的setImageDrawable函数绑定起来
 * <p>
 * Binding methods have to be applied to any class in your project. Even an empty one.
 * 绑定方法必须应用于项目中的任何类。即使是空的
 * <p>
 * This is equivalent to:
 * BindingMethods可以使用BindingAdapter来实现
 * ```
 * @BindingAdapter("app:srcCompat")
 * @JvmStatic fun srcCompat(view: ImageView, @DrawableRes drawableId: Int) {
 * view.setImageResource(drawable)
 * }
 * ```
 */

@BindingMethods({@BindingMethod(type = ImageView.class, attribute = "app:srcCompat", method = "setImageResource")})
public class MyBindingMethods {
}
