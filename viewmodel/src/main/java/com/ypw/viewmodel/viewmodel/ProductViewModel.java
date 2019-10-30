package com.ypw.viewmodel.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ypw.viewmodel.BaseApplication;
import com.ypw.viewmodel.DataRepository;
import com.ypw.viewmodel.db.entity.CommentEntity;
import com.ypw.viewmodel.db.entity.ProductEntity;

import java.util.List;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/29 0029
 * @pkn : com.ypw.viewmodel.viewmodel
 * @desc :
 */
public class ProductViewModel extends AndroidViewModel {
    private final LiveData<ProductEntity> mObservableProduct;
    private final LiveData<List<CommentEntity>> mObservableComments;
    public ObservableField<ProductEntity> product = new ObservableField<>();
    private final int mProductId;

    public ProductViewModel(@NonNull Application application, DataRepository repository,
                            final int productId) {
        super(application);
        mProductId = productId;
        mObservableComments = repository.loadComments(mProductId);
        mObservableProduct = repository.loadProduct(mProductId);
    }

    public LiveData<List<CommentEntity>> getComments() {
        return mObservableComments;
    }

    public LiveData<ProductEntity> getObservableProduct() {
        return mObservableProduct;
    }

    public void setProduct(ProductEntity product) {
        this.product.set(product);
    }


    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        @NonNull
        private final Application mApplication;

        private final int mProductId;

        private final DataRepository mRepository;

        public Factory(@NonNull Application application, int productId) {
            mApplication = application;
            mProductId = productId;
            mRepository = ((BaseApplication) application).getRepository();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ProductViewModel(mApplication, mRepository, mProductId);
        }
    }
}
