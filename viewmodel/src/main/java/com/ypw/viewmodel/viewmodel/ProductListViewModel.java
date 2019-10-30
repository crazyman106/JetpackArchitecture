package com.ypw.viewmodel.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.ypw.viewmodel.BaseApplication;
import com.ypw.viewmodel.DataRepository;
import com.ypw.viewmodel.db.entity.ProductEntity;

import java.util.List;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/30 0030
 * @pkn : com.ypw.viewmodel.viewmodel
 * @desc :
 */
public class ProductListViewModel extends AndroidViewModel {
    private final DataRepository mRepository;
    private final MediatorLiveData<List<ProductEntity>> mObservableProducts;

    public ProductListViewModel(@NonNull Application application) {
        super(application);
        mObservableProducts = new MediatorLiveData<>();
        // 在从数据库获取数据之前，默认设置为null。
        mObservableProducts.setValue(null);
        mRepository = ((BaseApplication) application).getRepository();
        LiveData<List<ProductEntity>> products = mRepository.getProducts();
        // 观察数据库的变换,并且通知mObservableProducts(当products变换是通知obsever:onChanged)
        mObservableProducts.addSource(products, mObservableProducts::setValue);
    }

    /**
     * 公开LiveData产品查询，以便UI能够观察它.
     */
    public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }

    public LiveData<List<ProductEntity>> searchProducts(String query) {
        return mRepository.searchProducts(query);
    }

}
