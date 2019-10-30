package com.ypw.viewmodel.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ypw.viewmodel.R;
import com.ypw.viewmodel.databinding.ProductFragmentBinding;
import com.ypw.viewmodel.db.entity.CommentEntity;
import com.ypw.viewmodel.db.entity.ProductEntity;
import com.ypw.viewmodel.model.Comment;
import com.ypw.viewmodel.viewmodel.ProductViewModel;

import java.util.List;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/29 0029
 * @pkn : com.ypw.viewmodel.ui
 * @desc :
 */
public class ProductFragment extends Fragment {
    private static final String KEY_PRODUCT_ID = "product_id";

    ProductFragmentBinding mBinding;
    private CommentAdapter mCommentAdapter;

    private final CommentClickCallback mCommentClickCallback = comment -> {
        // no-op
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.product_fragment, container, false);
        mCommentAdapter = new CommentAdapter(mCommentClickCallback);
        mBinding.commentList.setAdapter(mCommentAdapter);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ProductViewModel.Factory factory = new ProductViewModel.Factory(requireActivity().getApplication(), getArguments().getInt(KEY_PRODUCT_ID));
        final ProductViewModel model = new ViewModelProvider(this, factory).get(ProductViewModel.class);
        mBinding.setProductViewModel(model);
        subscribeToModel(model);
    }

    private void subscribeToModel(final ProductViewModel model) {
        model.getObservableProduct().observe(this, productEntity ->
                model.setProduct(productEntity));
        model.getComments().observe(this, commentEntities -> {
            if (commentEntities != null) {
                mBinding.setIsLoading(false);
                mCommentAdapter.setmCommentList(commentEntities);
            } else {
                mBinding.setIsLoading(true);
            }
        });
    }

    public static ProductFragment forProduct(int productId) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_PRODUCT_ID, productId);
        fragment.setArguments(args);
        return fragment;
    }
}
