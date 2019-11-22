package com.test.databinding_twoways.ui.test;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.example.android.databinding.twowaysample.ui.test.TestViewModel;
import com.example.android.databinding.twowaysample.ui.test.TestViewModelFactory;
import com.test.databinding_twoways.R;
import com.test.databinding_twoways.databinding.ActivityTestBinding;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/11/22 0022
 * @pkn : com.example.android.databinding.twowaysample.ui.test
 * @desc :
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        TestViewModel viewModel = ViewModelProviders.of(this, TestViewModelFactory.INSTANCE).get(TestViewModel.class);
        binding.setViewmodel(viewModel);
    }
}
