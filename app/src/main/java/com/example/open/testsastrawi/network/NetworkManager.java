package com.example.open.testsastrawi.network;

import android.content.Context;
import android.net.Uri;

import com.google.gson.JsonElement;

import java.io.File;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by rahardyan on 31/05/17.
 */

public class NetworkManager {
    private Context context;
    private NetworkService networkService;
    public NetworkManager(Context context, String baseUrl, boolean isDebug) {
        this.context = context;
        this.networkService = NetworkFactory.createNetwork(baseUrl, isDebug)
                .create(NetworkService.class);
    }

    /**
     * do networking method declaration
     */
}
