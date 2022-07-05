package com.quwi.apptest.screen.home.chat;

import androidx.lifecycle.MutableLiveData;

import com.quwi.apptest.base.BaseViewModel;
import com.quwi.apptest.data.model.chat.ChatResponse;
import com.quwi.apptest.network.api.ChatApi;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class ChatViewModel extends BaseViewModel {

    private final ChatApi chatApi;
    public MutableLiveData<ChatResponse> liveChat = new MutableLiveData<>();

    @Inject
    ChatViewModel(ChatApi chatApi) {
        this.chatApi = chatApi;
    }

    void getChat() {
        liveProgress.postValue(true);
        Disposable dispose = chatApi.getChat()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    liveChat.postValue(result);
                    liveProgress.postValue(false);
                }, error -> {
                    liveError.postValue(error);
                    liveProgress.postValue(false);
                });
        disposable.add(dispose);
    }
}
