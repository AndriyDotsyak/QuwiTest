package com.quwi.apptest.screen.adapter;

import static com.quwi.apptest.utils.ViewUtil.loadImage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.quwi.apptest.R;
import com.quwi.apptest.base.adapter.BaseAdapter;
import com.quwi.apptest.base.adapter.BaseViewHolder;
import com.quwi.apptest.data.model.chat.Channel;
import com.quwi.apptest.databinding.ItemChatBinding;

import java.util.Objects;

public class ChatAdapter extends BaseAdapter<Channel, ChatAdapter.ChatViewHolder> {

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflate(R.layout.item_chat, parent);
        return new  ChatViewHolder(view);
    }

    static class ChatViewHolder extends BaseViewHolder<Channel> {

        private ItemChatBinding binding = ItemChatBinding.bind(itemView);
        private Channel item;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void bindItem(Channel item) {
            this.item = item;

            initBinding();
            initUI();
        }

        private void initBinding() {
            binding.setChannel(item);
        }

        private void initUI() {
            loadImage(binding.ivAvatar, item.requireAvatarUrl(), R.drawable.ic_placeholder_avatar);
        }
    }
}
