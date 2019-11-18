package com.ypw.viewmodel.data;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/11/14 0014
 * @pkn : com.ypw.viewmodel.data
 * @desc :
 */
public class ViewModelUser {
    private String name;
    private String lastName;
    private int likes;

    public ViewModelUser() {
    }

    public ViewModelUser(String name, String lastName, int likes) {
        this.name = name;
        this.lastName = lastName;
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "ViewModelUser{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", likes=" + likes +
                '}';
    }
}
