package com.test.adproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.test.adproject.net.ApiService;
import com.test.adproject.net.AppClient;
import com.test.adproject.net.LoginParams;
import com.test.adproject.net.Sign;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppClient.getApiService().login1(new LoginParams()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {

                    }
                });
    }
}
