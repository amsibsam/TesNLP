package com.example.open.testsastrawi;

import android.app.Application;

import com.example.open.testsastrawi.model.Marine;
import com.example.open.testsastrawi.nlp.SastrawiWrapper;
import com.example.open.testsastrawi.nlp.SimilarityWrapper;

/**
 * Created by Rahardyan on 12/1/2017.
 */

public class SastrawiApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Marine.init(this);
    }
}
