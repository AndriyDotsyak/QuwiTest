package com.quwi.apptest.screen.authenticate.login;

import androidx.lifecycle.MutableLiveData;

import com.quwi.apptest.base.BaseViewModel;
import com.quwi.apptest.data.model.authenticate.Credentials;
import com.quwi.apptest.data.model.authenticate.User;
import com.quwi.apptest.manager.AccountManager;
import com.quwi.apptest.network.api.AuthenticateApi;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class LoginViewModel extends BaseViewModel {

    private final AuthenticateApi authenticateApi;
    private final AccountManager accountManager;
    public MutableLiveData<User> liveLogin = new MutableLiveData<>();

    @Inject
    LoginViewModel(
            AuthenticateApi authenticateApi,
            AccountManager accountManager
    ) {
        this.authenticateApi = authenticateApi;
        this.accountManager = accountManager;
    }

    void login(Credentials credentials) {
        liveProgress.postValue(true);
        Disposable dispose = authenticateApi.login(credentials)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    accountManager.putToken(result.token);
                    liveLogin.postValue(result.data.user);
                    liveProgress.postValue(false);
                }, error -> {
                    liveError.postValue(error);
                    liveProgress.postValue(false);
                });
        disposable.add(dispose);
    }

    boolean hasToken() {
        return accountManager.hasToken();
    }

}
