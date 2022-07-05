package com.quwi.apptest.screen.authenticate.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.quwi.apptest.R;
import com.quwi.apptest.base.BaseFragment;
import com.quwi.apptest.data.model.authenticate.Credentials;
import com.quwi.apptest.data.model.authenticate.User;
import com.quwi.apptest.databinding.FragmentLoginBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment<FragmentLoginBinding> {

    private LoginViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        initLiveData();
        initListeners();
    }

    private void initData() {
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    private void initLiveData() {
        observeLiveData(viewModel.liveLogin, this::handleLogin);
        observeLiveData(viewModel.liveError, this::handleError);
        observeLiveData(viewModel.liveProgress, this::onProgress);
    }

    private void initListeners() {
        binding.btnLogin.setOnClickListener(view -> {
            viewModel.login(getCredentials());
            hideKeyboard();
        });
        binding.btnRegistration.setOnClickListener(view -> {
            navigate(LoginFragmentDirections.actionRegistration());
        });
    }

    private Credentials getCredentials() {
        return new Credentials(
                binding.etEmail.getText().toString(),
                binding.etPassword.getText().toString()
        );
    }

    @Override
    public void onProgress(Boolean isProgress) {
        binding.btnLogin.setEnabled(!isProgress);
    }

    private void handleLogin(User user) {
        navigate(LoginFragmentDirections.actionHome());
        requireActivity().finish();
    }

    private void handleError(Throwable error) {
        showToast(error.getMessage());
    }
}
