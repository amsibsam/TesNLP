package com.example.open.testsastrawi.base;

import android.content.Context;

import com.example.open.testsastrawi.network.NetworkManager;

/**
 * Created by rahardyan on 31/05/17.
 */

public class BasePresenter {
    protected final NetworkManager networkManager;
    protected Context context;

    public BasePresenter(Context context) {
        this.context = context;
        this.networkManager = new NetworkManager(context, "", true);
    }
}
