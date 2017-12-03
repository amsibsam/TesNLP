package com.example.open.testsastrawi;

import android.app.Application;
/**
 * Created by Rahardyan on 12/1/2017.
 */

public class SastrawiApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SastrawiWrapper.getInstance().init();
        SimilarityWrapper.getInstance().init();
    }
}
