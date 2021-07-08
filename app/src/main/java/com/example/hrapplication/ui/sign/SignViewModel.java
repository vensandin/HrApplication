package com.example.hrapplication.ui.sign;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SignViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Sign fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}