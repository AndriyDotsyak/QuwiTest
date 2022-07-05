package com.quwi.apptest.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.quwi.apptest.R;

public class ViewUtil {

    public static void updateProgress(Boolean isProgress, Window window, View container) {
        AndroidUtil.setTouchableWindow(window, !isProgress);

        if (isProgress) {
            showProgress(container);
        } else {
            hideProgress(container);
        }
    }

    public static void showProgress(View container) {
        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());
        View progress = layoutInflater.inflate(R.layout.content_progress, null);
        progress.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );

        ((ViewGroup) progress).addView(progress);
    }

    public static void hideProgress(View container) {
        ViewGroup progress = container.findViewById(R.id.conProgress);
        progress.removeView(progress);
    }

    public static void loadImage(
            ImageView imageView,
            String url,
            @DrawableRes int defaultImageRes
    ) {
        Glide.with(imageView)
                .load(url)
                .placeholder(defaultImageRes)
                .into(imageView);
    }

    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView)
                .load(url)
                .into(imageView);
    }

    @BindingAdapter("android:visibility")
    public static void updateVisible(View view, Boolean isVisible) {
        if (isVisible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

}