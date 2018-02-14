package com.example.open.testsastrawi.nlp.naivebeyesclassifier.training;

import android.content.Context;

import com.example.open.testsastrawi.model.Marine;
import com.example.open.testsastrawi.storage.CacheManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rahardyan on 12/17/2017.
 */

public class NBTrainingDataInstance {
    private static NBTrainingDataInstance instance;
    private Context context;

    public static void initDataTraining(Context context) {
        instance = new NBTrainingDataInstance(context);
    }

    private NBTrainingDataInstance(Context context) {
        this.context = context;
        initiateDataTrainingSet();
    }

    private void initiateDataTrainingSet() {
        initiateGreetingData();
        initiateGoodbyeData();
        initiatePersonalData();
    }

    private void initiateGreetingData() {
        List<NBTrainingModel> trainingModels = new ArrayList<>();

        trainingModels.add(new NBTrainingModel("greetings", "halo", 1));
        trainingModels.add(new NBTrainingModel("greetings", "apa", 1));
        trainingModels.add(new NBTrainingModel("greetings", "assalamualaikum", 1));
        trainingModels.add(new NBTrainingModel("greetings", "selamat", 1));
        trainingModels.add(new NBTrainingModel("greetings", "pagi", 1));
        trainingModels.add(new NBTrainingModel("greetings", "siang", 1));
        trainingModels.add(new NBTrainingModel("greetings", "sore", 1));
        trainingModels.add(new NBTrainingModel("greetings", "malam", 1));
        trainingModels.add(new NBTrainingModel("greetings", "kabar", 1));
        trainingModels.add(new NBTrainingModel("greetings", "kenal", 1));

        NBTrainingModelList nbTrainingModelList = new NBTrainingModelList(trainingModels);
        CacheManager.getInstance(context).updateTrainingData(nbTrainingModelList);
    }

    private void initiateGoodbyeData() {
        List<NBTrainingModel> trainingModels = new ArrayList<>();
        trainingModels.add(new NBTrainingModel("goodbye", "oke", 1));
        trainingModels.add(new NBTrainingModel("goodbye", "terimakasih", 1));
        trainingModels.add(new NBTrainingModel("goodbye", "selamat", 1));
        trainingModels.add(new NBTrainingModel("goodbye", "tinggal", 1));

        NBTrainingModelList nbTrainingModelList = new NBTrainingModelList(trainingModels);
        CacheManager.getInstance(context).updateTrainingData(nbTrainingModelList);
    }

    private void initiatePersonalData() {
        List<NBTrainingModel> trainingModels = new ArrayList<>();
        trainingModels.add(new NBTrainingModel("personal", "siapa", 1));
        trainingModels.add(new NBTrainingModel("personal", "nama", 1));
        trainingModels.add(new NBTrainingModel("personal", "kamu", 1));
        trainingModels.add(new NBTrainingModel("personal", "berapa", 1));
        trainingModels.add(new NBTrainingModel("personal", "umur", 1));
        trainingModels.add(new NBTrainingModel("personal", "usia", 1));
        trainingModels.add(new NBTrainingModel("personal", "di mana", 1));

        NBTrainingModelList nbTrainingModelList = new NBTrainingModelList(trainingModels);
        CacheManager.getInstance(context).updateTrainingData(nbTrainingModelList);
    }

    private void initiateLeaveData() {

    }
}
