package com.quwi.apptest.screen.authenticate.registration;

import androidx.lifecycle.MutableLiveData;

import com.quwi.apptest.base.BaseViewModel;
import com.quwi.apptest.data.model.authenticate.Registration;
import com.quwi.apptest.data.model.authenticate.User;
import com.quwi.apptest.manager.AccountManager;
import com.quwi.apptest.network.api.AuthenticateApi;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class RegistrationViewModel extends BaseViewModel {

    private final AuthenticateApi authenticateApi;
    private final AccountManager accountManager;
    public MutableLiveData<User> liveRegistration = new MutableLiveData<>();

    @Inject
    RegistrationViewModel(
            AuthenticateApi authenticateApi,
            AccountManager accountManager
    ) {
        this.authenticateApi = authenticateApi;
        this.accountManager = accountManager;
    }

    void registration(Registration registration) {
        liveProgress.postValue(true);
        Disposable dispose = authenticateApi.signup(registration)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    accountManager.putToken(result.token);
                    liveRegistration.postValue(result.data.user);
                    liveProgress.postValue(false);
                }, error -> {
                    liveError.postValue(error);
                    liveProgress.postValue(false);
                });
        disposable.add(dispose);
    }

}
