package com.quwi.apptest.screen.authenticate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.quwi.apptest.AuthenticateDirections;
import com.quwi.apptest.R;
import com.quwi.apptest.base.BaseActivity;
import com.quwi.apptest.databinding.ActivityAuthenticateBinding;
import com.quwi.apptest.manager.AccountManager;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AuthenticateActivity extends BaseActivity<ActivityAuthenticateBinding> {

    @Inject
    AccountManager accountManager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_authenticate;
    }

    @Override
    public int getFragmentContainerId() {
        return R.id.navHostFragment;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initScreen();
    }

    private void initScreen() {
        if (accountManager.hasToken()) {
            navigate(AuthenticateDirections.actionHome());
            finish();
        } else {
            binding.navHostFragment.setVisibility(View.VISIBLE);
        }
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, AuthenticateActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
