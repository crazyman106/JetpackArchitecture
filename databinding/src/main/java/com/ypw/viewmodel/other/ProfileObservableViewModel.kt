package com.ypw.viewmodel.other

import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ypw.viewmodel.utils.ObservableViewModel
import com.ypw.viewmodel.utils.Popularity

class ProfileLiveDataViewModel : ViewModel() {
    private val _name = MutableLiveData("Ada")
    private val _lastName = MutableLiveData("Lovelace")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes

    // popularity is exposed as LiveData using a Transformation instead of a @Bindable property.
    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }
}

class ProfileObservableViewModel : ObservableViewModel() {
    val name = ObservableField("Ada")
    val lastName = ObservableField("Lovelace")
    val likes = ObservableInt(0)

    fun onLike() {
        likes.increment()
        // You control when the @Bindable properties are updated using `notifyPropertyChanged()`.
//        notifyPropertyChanged(BR.popularity)
    }
    //TODO 该函数在引用到xml中才可以使用
//    @Bindable
//    fun getPopularity(): Popularity {
//        return likes.get().let {
//            when {
//                it > 9 -> Popularity.STAR
//                it > 4 -> Popularity.POPULAR
//                else -> Popularity.NORMAL
//            }
//        }
//    }
}


private fun ObservableInt.increment() {
    set(get() + 1)
}