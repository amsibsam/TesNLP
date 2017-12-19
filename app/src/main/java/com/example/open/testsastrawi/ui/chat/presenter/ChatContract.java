package com.example.open.testsastrawi.ui.chat.presenter;

/**
 * Created by Rahardyan on 12/15/2017.
 */

public class ChatContract {
    interface UserActionListener {
        void sendMessage(String message);
        void receiveMessage(String message);
    }

    interface View {

    }
}
