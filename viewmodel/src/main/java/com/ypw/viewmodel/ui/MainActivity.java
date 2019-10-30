package com.ypw.viewmodel.ui;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.ypw.viewmodel.AppExecutors;
import com.ypw.viewmodel.BaseApplication;
import com.ypw.viewmodel.R;
import com.ypw.viewmodel.db.AppDatabase;
import com.ypw.viewmodel.db.dao.ProductDao;
import com.ypw.viewmodel.db.entity.ProductEntity;
import com.ypw.viewmodel.model.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ProductListFragment fragment = new ProductListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, ProductListFragment.TAG).commit();
        }
    }

    public void show(Product product) {
        ProductFragment productFragment = ProductFragment.forProduct(product.getId());
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack("product")
                .replace(R.id.fragment_container,
                        productFragment, null).commit();
    }
}
