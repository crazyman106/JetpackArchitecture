package com.ypw.viewmodel.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.ypw.viewmodel.R;
import com.ypw.viewmodel.databinding.ActivityMainBinding;


/**
 * databinding:通过页面和数据绑定展示数据
 * 数据绑定分为两种方式
 * 1.Observable:通过继承Observable;或者是持有实际对象的Observable来实现UI页面上数据的改变
 * 2.ViewModel+LiveData:
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.observableActivityButton.setOnClickListener(v -> {
            startActivity(new Intent(this, ObservableActivity.class));
        });
        binding.viewmodelActivityButton.setOnClickListener(v -> {
            startActivity(new Intent(this, ViewModelActivity.class));
        });
    }
}
