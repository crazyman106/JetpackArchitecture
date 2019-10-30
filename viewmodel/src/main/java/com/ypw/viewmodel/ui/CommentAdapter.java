package com.ypw.viewmodel.ui;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.ypw.viewmodel.R;
import com.ypw.viewmodel.databinding.CommentItemBinding;
import com.ypw.viewmodel.model.Comment;
import com.ypw.viewmodel.model.Product;

import java.util.List;
import java.util.Objects;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/29 0029
 * @pkn : com.ypw.viewmodel.ui
 * @desc :
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    private List<? extends Comment> mCommentList;
    @Nullable
    private final CommentClickCallback mCommentClickCallback;

    public CommentAdapter(CommentClickCallback mCommentClickCallback) {
        this.mCommentClickCallback = mCommentClickCallback;
    }

    public void setmCommentList(final List<? extends Comment> comments) {
        if (mCommentList == null) {
            mCommentList = comments;
            notifyItemRangeInserted(0, comments.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mCommentList.size();
                }

                @Override
                public int getNewListSize() {
                    return comments.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    Comment old = mCommentList.get(oldItemPosition);
                    Comment comment = comments.get(newItemPosition);
                    return old.getId() == comment.getId();
                }

                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Comment old = mCommentList.get(oldItemPosition);
                    Comment comment = comments.get(newItemPosition);
                    return old.getId() == comment.getId()
                            && old.getPostedAt() == comment.getPostedAt()
                            && old.getProductId() == comment.getProductId()
                            && Objects.equals(old.getText(), comment.getText());
                }
            });
            mCommentList = comments;
            result.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CommentItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.comment_item, parent, false);
        binding.setCallback(mCommentClickCallback);
        return new CommentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        holder.binding.setComment(mCommentList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mCommentList == null ? 0 : mCommentList.size();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder {

        CommentItemBinding binding;

        public CommentViewHolder(CommentItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
