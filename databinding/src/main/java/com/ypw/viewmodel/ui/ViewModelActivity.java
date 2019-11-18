package com.ypw.viewmodel.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.ypw.viewmodel.R;
import com.ypw.viewmodel.data.ProfileLiveDataViewModel;
import com.ypw.viewmodel.databinding.ViewmodelProfileBinding;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/11/14 0014
 * @pkn : com.ypw.viewmodel.ui
 * @desc :
 */
public class ViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtain binding
        ViewmodelProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.viewmodel_profile);

        // Obtain ViewModel from ViewModelProviders
        ProfileLiveDataViewModel viewModel = ViewModelProviders.of(this).get(ProfileLiveDataViewModel.class);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);
    }
}
