package com.example.open.testsastrawi.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.open.testsastrawi.model.User;
import com.example.open.testsastrawi.nlp.naivebeyesclassifier.training.NBTrainingModel;
import com.example.open.testsastrawi.nlp.naivebeyesclassifier.training.NBTrainingModelList;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rahardyan on 12/15/2017.
 */

public class CacheManager {
    private static CacheManager INSTANCE;
    private SharedPreferences preferences;
    private Gson gson;
    private List<String> greetingsResponse = new ArrayList<>();
    private List<String> personalQuestions = new ArrayList<>();

    private CacheManager(Context context) {
        this.preferences = context.getSharedPreferences(CacheManager.class.getSimpleName(), Context.MODE_PRIVATE);
        this.gson = new Gson();
    }

    public static CacheManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CacheManager(context);
        }

        return INSTANCE;
    }

    public void saveUser(User user) {
        preferences.edit().putString("username", user.getUsername()).apply();
    }

    public User getUser() {
        User user = new User(preferences.getString("username", ""));
        return user;
    }

    public void updateTrainingData(NBTrainingModelList modelList) {
        if (preferences.getString("training_data", "").isEmpty()) {
            String jsonModelList = gson.toJson(modelList);
            preferences.edit().putString("training_data", jsonModelList).apply();
        } else {
            String jsonModelList = preferences.getString("training_data", "");

            if (!jsonModelList.isEmpty()) {
                NBTrainingModelList modelListObj = gson.fromJson(jsonModelList, NBTrainingModelList.class);

                for (NBTrainingModel newTrainingModel: modelList.getTraningData()) {
                    if (!modelListObj.getTraningData().contains(newTrainingModel)) {
                        modelListObj.getTraningData().addAll(modelList.getTraningData());
                    }
                }

                String newJsonModelList = gson.toJson(modelListObj);
                preferences.edit().putString("training_data", newJsonModelList).apply();
            }
        }
    }

    public NBTrainingModelList getTrainingData() {
        if (!preferences.getString("training_data", "").isEmpty()) {
            return gson.fromJson(preferences.getString("training_data", ""), NBTrainingModelList.class);
        } else {
            return null;
        }
    }

    public void initiateGreetingResponse() {
//        preferences.edit().
    }
}
