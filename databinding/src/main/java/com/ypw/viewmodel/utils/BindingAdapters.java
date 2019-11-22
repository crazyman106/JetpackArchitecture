package com.ypw.viewmodel.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.databinding.BindingAdapter;
import com.ypw.viewmodel.R;
import kotlin.Suppress;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/11/13 0013
 * @pkn : com.ypw.viewmodel.utils
 * @desc :
 */
public class BindingAdapters {

    /**
     * if (this > maximumValue) maximumValue else this
     * Sets the value of the progress bar so that 5 likes will fill it up.
     * <p>
     * Showcases Binding Adapters with multiple attributes. Note that this adapter is called
     * whenever any of the attribute changes.
     * <p>
     * 为ProgressBar指定两个属性,分别是max,progressScaled,android:xxx,一般默认使用app:xxx,使用requireAll表示所有的属性是否全部书写
     * <p>
     * <p>
     * (likes * max / 5).coerceAtMost(max)
     * <p>
     * if (this > maximumValue) maximumValue else this
     * <p>
     * value = {"android:max", "android:progressScaled"}中的参数顺序要和setProgress(ProgressBar progress, int max, int likes)中的参数顺序对应
     */
    @BindingAdapter(value = {"android:max", "android:progressScaled"}, requireAll = true)
    public static void setProgress(ProgressBar progress, int max, int likes) {
        Log.e("setProgress", "like:" + likes + "  max:" + max);
        progress.setProgress((likes * max / 5) > max ? max : (likes * max / 5));
    }

    @Suppress(names = "unused")
    @BindingAdapter("app:popularityIcon")
    public static void popularityIcon(ImageView imageView, Popularity popularity) {
        Drawable drawable = getAssociatedDrawable(popularity, imageView.getContext());
        int color = getAssociatedColor(popularity, imageView.getContext());
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color));
        imageView.setImageDrawable(drawable);
    }


    @BindingAdapter("app:progressTint")
    public static void popularityTint(ProgressBar view, Popularity popularity) {
        int color = getAssociatedColor(popularity, view.getContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setProgressTintList(ColorStateList.valueOf(color));
        }
    }

    @Suppress(names = "unused")
    @BindingAdapter("app:hideIfZero")
    public static void hideIfZero(View view, int number) {
        view.setVisibility(number == 0 ? View.GONE : View.VISIBLE);
    }

    private static int getAssociatedColor(Popularity popularity, Context context) {
        switch (popularity) {
            case STAR:
                return ContextCompat.getColor(context, R.color.star);
            case NORMAL:
                return context.getTheme().obtainStyledAttributes(
                        new int[]{android.R.attr.colorForeground}).getColor(0, 0x000000);
            case POPULAR:
                return ContextCompat.getColor(context, R.color.popular);
            default:
        }
        return Color.WHITE;
    }

    private static Drawable getAssociatedDrawable(Popularity popularity, Context context) {
        switch (popularity) {
            case NORMAL:
                return ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp);
            case POPULAR:
                return ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp);
            case STAR:
                return ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp);
            default:
        }
        return new ColorDrawable(Color.WHITE);
    }

}
