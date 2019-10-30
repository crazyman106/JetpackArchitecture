package com.ypw.rxjavaroom;

import android.content.Context;
import com.ypw.rxjavaroom.persistence.LocalUserDataSource;
import com.ypw.rxjavaroom.persistence.UserDatabase;
import com.ypw.rxjavaroom.ui.ViewModelFactory;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/24 0024
 * @pkn : com.ypw.rxjavaroom
 * @desc :
 */
public class Injection {
    public static UserDataSource provideUserDataSource(Context context) {
        UserDatabase database = UserDatabase.getInstance(context);
        return new LocalUserDataSource(database.userDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = provideUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}
