package com.example.open.testsastrawi.ui.chat.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.open.testsastrawi.base.BasePresenter;

/**
 * Created by Rahardyan on 12/15/2017.
 */

public class ChatPresenter extends BasePresenter implements ChatContract.UserActionListener {
    @NonNull
    private ChatContract.View chatView;

    public ChatPresenter(@NonNull Context context, @NonNull ChatContract.View chatView) {
        super(context);
        this.chatView = chatView;
    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void receiveMessage(String message) {

    }
}
