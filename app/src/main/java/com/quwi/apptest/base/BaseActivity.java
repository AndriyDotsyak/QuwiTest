package com.quwi.apptest.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.quwi.apptest.utils.AndroidUtil;
import com.quwi.apptest.utils.ViewUtil;

import timber.log.Timber;

public abstract class BaseActivity<VDB extends ViewDataBinding> extends AppCompatActivity {

    public VDB binding;

    public NavController getNavController() {
        return findNavController(getFragmentContainerId());
    }

    public abstract int getLayoutId();

    public int getFragmentContainerId() {
        return -1;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = getDtaBinding();
    }

    private VDB getDtaBinding() {
        return DataBindingUtil.setContentView(this, getLayoutId());
    }

    private NavController findNavController(@IdRes int fragmentContainerId) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(fragmentContainerId);
        return ((NavHostFragment) fragment).getNavController() ;
    }

    public void navigate(NavDirections navDirections) {
        try {
            getNavController().navigate(navDirections);
        } catch (Exception error) {
            Timber.e(error);
        }
    }

    public void onProgress(Boolean isProgress) {
        ViewUtil.updateProgress(isProgress, getWindow(), binding.getRoot());
    }

    public <T> void observeLiveData(LiveData<T> liveData, Observer<T> observer) {
        liveData.observe(this, observer);
    }

    void hideKeyboard() {
        AndroidUtil.hideKeyboard(this);
    }

    void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

}
