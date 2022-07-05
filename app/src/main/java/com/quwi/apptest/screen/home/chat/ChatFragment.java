package com.quwi.apptest.screen.home.chat;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.quwi.apptest.R;
import com.quwi.apptest.base.BaseFragment;
import com.quwi.apptest.data.model.chat.ChatResponse;
import com.quwi.apptest.databinding.FragmentChatBinding;
import com.quwi.apptest.manager.AccountManager;
import com.quwi.apptest.screen.adapter.ChatAdapter;
import com.quwi.apptest.screen.authenticate.AuthenticateActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ChatFragment extends BaseFragment<FragmentChatBinding> {

    @Inject
    AccountManager accountManager;

    private ChatViewModel viewModel;
    private ChatAdapter chatAdapter = new  ChatAdapter();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_chat;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        initUI();
        initLiveData();
        initListeners();

        viewModel.getChat();
    }

    private void initData() {
        viewModel = new ViewModelProvider(this).get(ChatViewModel.class);
    }

    private void initUI() {
        binding.rvChat.setAdapter(chatAdapter);
    }

    private void initLiveData() {
        observeLiveData(viewModel.liveChat, this::handleChat);
    }

    private void initListeners() {
        binding.btnLogout.setOnClickListener(view -> {
            accountManager.clear();
            AuthenticateActivity.start(getContext());
        });
    }

    @Override
    public void onProgress(Boolean isProgress) {
        super.onProgress(isProgress);

        if (isProgress) {
            binding.progress.getRoot().setVisibility(View.VISIBLE);
        } else {
            binding.progress.getRoot().setVisibility(View.GONE);
        }
    }

    private void handleChat(ChatResponse chat) {
        chatAdapter.addItems(chat.channels);
    }
}
