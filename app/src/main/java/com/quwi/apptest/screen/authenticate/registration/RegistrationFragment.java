package com.quwi.apptest.screen.authenticate.registration;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.quwi.apptest.R;
import com.quwi.apptest.base.BaseFragment;
import com.quwi.apptest.data.model.authenticate.Registration;
import com.quwi.apptest.data.model.authenticate.User;
import com.quwi.apptest.databinding.FragmentRegistrationBinding;
import com.quwi.apptest.screen.authenticate.login.LoginFragmentDirections;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegistrationFragment extends BaseFragment<FragmentRegistrationBinding> {

    private RegistrationViewModel viewModel;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_registration;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        initLiveData();
        initListeners();
    }

    private void initData() {
        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
    }

    private void initLiveData() {
        observeLiveData(viewModel.liveRegistration, this::handleRegistration);
        observeLiveData(viewModel.liveError, this::handleError);
    }

    private void initListeners() {
        binding.btnRegistration.setOnClickListener(view -> {
            viewModel.registration(getRegistration());
            hideKeyboard();
        });
        binding.btnLogin.setOnClickListener(view -> {
            navigate(RegistrationFragmentDirections.actionLogin());
        });
    }

    private Registration getRegistration() {
        return new Registration(
                binding.etName.getText().toString(),
                binding.etEmail.getText().toString(),
                binding.etPassword.getText().toString()
        );
    }

    @Override
    public void onProgress(Boolean isProgress) {
        binding.btnRegistration.setEnabled(!isProgress);
    }

    private void handleRegistration(User user) {
        navigate(LoginFragmentDirections.actionHome());
        requireActivity().finish();
    }

    private void handleError(Throwable error) {
        showToast(error.getMessage());
    }
}
