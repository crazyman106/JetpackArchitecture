package com.ypw.viewmodel.utils;

import android.view.View;
import androidx.databinding.BindingConversion;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/11/14 0014
 * @pkn : com.ypw.viewmodel.utils
 * @desc :
 */
public class BindingConverters {

    @BindingConversion
    public static int booleanToVisibility(boolean isInVisibility) {
        return isInVisibility ? View.GONE : View.VISIBLE;
    }
}
