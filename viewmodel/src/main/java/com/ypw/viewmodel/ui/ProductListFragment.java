package com.ypw.viewmodel.ui;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ypw.viewmodel.R;
import com.ypw.viewmodel.databinding.ListFragmentBinding;
import com.ypw.viewmodel.databinding.ProductFragmentBinding;
import com.ypw.viewmodel.db.entity.ProductEntity;
import com.ypw.viewmodel.model.Comment;
import com.ypw.viewmodel.model.Product;
import com.ypw.viewmodel.viewmodel.ProductListViewModel;

import java.util.List;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/29 0029
 * @pkn : com.ypw.viewmodel.ui
 * @desc :
 */
public class ProductListFragment extends Fragment {
    public static final String TAG = "ProductListFragment";
    private ProductAdapter mProductAdapter;
    private ListFragmentBinding mBinding;

    private final ProductClickCallback mProductClickCallback = product -> {
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            ((MainActivity) getActivity()).show(product);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false);
        mProductAdapter = new ProductAdapter(mProductClickCallback);
        mBinding.productsList.setAdapter(mProductAdapter);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 获取model
        final ProductListViewModel viewModel = new ViewModelProvider(this).get(ProductListViewModel.class);
        mBinding.productsSearchBtn.setOnClickListener(view -> {
            Editable query = mBinding.productsSearchBox.getText();
            if (query == null || query.toString().isEmpty()) {
                subscribeUI(viewModel.getProducts());
            } else {
                subscribeUI(viewModel.searchProducts("*" + query + "*"));
            }
        });
        subscribeUI(viewModel.getProducts());
    }

    private void subscribeUI(LiveData<List<ProductEntity>> liveData) {
        liveData.observe(this, productEntities -> {
            if (productEntities != null) {
                mBinding.setIsLoading(false);
                mProductAdapter.setProductList(productEntities);
            } else {
                mBinding.setIsLoading(true);
            }
            mBinding.executePendingBindings();
        });
    }
}
