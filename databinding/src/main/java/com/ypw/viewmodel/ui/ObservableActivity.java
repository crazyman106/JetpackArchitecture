package com.ypw.viewmodel.ui;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.ypw.viewmodel.R;
import com.ypw.viewmodel.data.ObservableProfile;
import com.ypw.viewmodel.databinding.ObservableProfileBinding;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/11/6 0006
 * @pkn : com.ypw.viewmodel.ui
 * @desc :
 */
public class ObservableActivity extends AppCompatActivity {
    private ObservableProfile observableProfile = new ObservableProfile("Ada", "Lovelace", 0);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ObservableProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.observable_profile);
        binding.setUser(observableProfile);
    }

    public void onLike(View view) {
        observableProfile.setLikes(observableProfile.getLikes() + 1);
    }
}
