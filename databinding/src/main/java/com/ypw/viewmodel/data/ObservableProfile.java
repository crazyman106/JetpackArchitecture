package com.ypw.viewmodel.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.ypw.viewmodel.BR;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/11/6 0006
 * @pkn : com.ypw.viewmodel.data
 * @desc :
 */
public class ObservableProfile extends BaseObservable {
    private String name;
    private String lastName;
    private int likes;


    public ObservableProfile() {
    }

    public ObservableProfile(String name, String lastName, int likes) {
        this.name = name;
        this.lastName = lastName;
        this.likes = likes;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
        notifyPropertyChanged(BR.likes);
    }

    @Override
    public String toString() {
        return "ObservableProfile{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", likes=" + likes +
                '}';
    }
}
