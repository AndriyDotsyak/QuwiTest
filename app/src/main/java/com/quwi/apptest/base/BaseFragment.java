package com.quwi.apptest.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.quwi.apptest.utils.AndroidUtil;
import com.quwi.apptest.utils.ViewUtil;

import timber.log.Timber;

public abstract class BaseFragment<VDB extends ViewDataBinding> extends Fragment {

    public VDB binding;

    public abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return binding.getRoot();
    }

    public void onProgress(Boolean isProgress) {
        ViewUtil.updateProgress(isProgress, requireActivity().getWindow(), binding.getRoot());
    }

    public void navigate(NavDirections navDirections) {
        try {
            NavHostFragment.findNavController(this).navigate(navDirections);
        } catch (Exception error) {
            Timber.e(error);
        }
    }

    public <T> void observeLiveData(LiveData<T> liveData, Observer<T> observer) {
        liveData.observe(getViewLifecycleOwner(), observer);
    }

    public void hideKeyboard() {
        AndroidUtil.hideKeyboard(requireActivity());
    }

    public void showToast(String text) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show();
    }

    public void showToast(@StringRes int textRes) {
        Toast.makeText(requireContext(), textRes, Toast.LENGTH_LONG).show();
    }

}
