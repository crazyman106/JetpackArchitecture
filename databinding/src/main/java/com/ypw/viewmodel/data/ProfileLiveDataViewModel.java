package com.ypw.viewmodel.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.ypw.viewmodel.utils.Popularity;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/11/14 0014
 * @pkn : com.ypw.viewmodel.data
 * @desc :
 * * This class is used as a variable in the XML layout and it's fully observable, meaning that
 * * changes to any of the exposed observables automatically refresh the UI. *
 */

public class ProfileLiveDataViewModel extends ViewModel {
    private MutableLiveData<ViewModelUser> userViewModel;
    private LiveData<Popularity> popularityViewModel;

    public ProfileLiveDataViewModel() {
        userViewModel = new MutableLiveData<>();
        userViewModel.setValue(new ViewModelUser("李", "俊杰", 0));
        popularityViewModel = Transformations.map(userViewModel, input -> {
            if (input.getLikes() > 9) {
                return Popularity.STAR;
            } else if (input.getLikes() > 4) {
                return Popularity.POPULAR;
            } else {
                return Popularity.NORMAL;
            }
        });
    }

    public LiveData<Popularity> getPopularityViewModel() {
        return popularityViewModel;
    }

    public MutableLiveData<ViewModelUser> getUserViewModel() {
        return userViewModel;
    }

    public void onLike() {
        userViewModel.getValue().setLikes(userViewModel.getValue().getLikes() + 1);
        userViewModel.setValue(userViewModel.getValue()); //
//        userViewModel.postValue(userViewModel.getValue());

    }

}
