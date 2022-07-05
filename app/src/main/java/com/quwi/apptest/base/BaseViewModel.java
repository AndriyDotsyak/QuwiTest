package com.quwi.apptest.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    public CompositeDisposable disposable = new CompositeDisposable();
    public MutableLiveData<Throwable> liveError = new MutableLiveData<>();
    public MutableLiveData<Boolean> liveProgress = new MutableLiveData<>();

    @Override
    protected void onCleared() {
        super.onCleared();

        disposable.dispose();
        disposable.clear();
    }
}
