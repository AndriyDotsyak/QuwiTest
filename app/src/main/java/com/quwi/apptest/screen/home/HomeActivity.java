package com.quwi.apptest.screen.home;

import com.quwi.apptest.R;
import com.quwi.apptest.base.BaseActivity;
import com.quwi.apptest.databinding.ActivityHomeBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity<ActivityHomeBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }
}
