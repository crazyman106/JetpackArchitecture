package com.example.android.databinding.twowaysample.ui.test

import androidx.databinding.Bindable
import com.test.databinding_twoways.util.ObservableViewModel
import androidx.databinding.ObservableInt
import com.test.databinding_twoways.BR


/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/11/22 0022
 *  @pkn    : com.example.android.databinding.twowaysample.ui.test
 *  @desc   :
 */
class TestViewModel : ObservableViewModel() {

    var value: String = ""
        @Bindable
        get
        set(value) {
            field = value
            notifyPropertyChanged(BR.value)
        }

    var progress: Int = 0
        @Bindable
        get
        set(value) {
            if (value != field) {
                field = value
                notifyPropertyChanged(BR.progress)
            }
        }
}