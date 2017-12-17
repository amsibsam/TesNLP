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

        trainingModels.add(new NBTrainingModel("greetings", "halo", new String[]{"hi", "halo juga"}));
        trainingModels.add(new NBTrainingModel("greetings", "apa kabar", new String[]{"super sekali", "baik", "biasa saja"}));
        trainingModels.add(new NBTrainingModel("greetings", "Assalamualaikum", new String[]{"waalaikumussalam"}));
        trainingModels.add(new NBTrainingModel("greetings", "Selamat siang", new String[]{"halo, ada yang bisa dibanting ? \neh dibantu"}));

        NBTrainingModelList nbTrainingModelList = new NBTrainingModelList(trainingModels);
        CacheManager.getInstance(context).updateTrainingData(nbTrainingModelList);
    }

    private void initiateGoodbyeData() {
        List<NBTrainingModel> trainingModels = new ArrayList<>();
        trainingModels.add(new NBTrainingModel("goodbye", "oke terimakasih", new String[]{"sama-sama"}));
        trainingModels.add(new NBTrainingModel("goodbye", "baiklah", new String[]{"oke, siap"}));
        trainingModels.add(new NBTrainingModel("goodbye", "sampai jumpa", new String[]{"dadah"}));

        NBTrainingModelList nbTrainingModelList = new NBTrainingModelList(trainingModels);
        CacheManager.getInstance(context).updateTrainingData(nbTrainingModelList);
    }

    private void initiatePersonalData() {
        List<NBTrainingModel> trainingModels = new ArrayList<>();
        trainingModels.add(new NBTrainingModel("personal", "siapa namamu", new String[]{"namaku "+ Marine.getInstance().getName(), Marine.getInstance().getName(), "aku" + Marine.getInstance().getName()}));
        trainingModels.add(new NBTrainingModel("personal", "berapa umurmu ?", new String[]{"aku lahir tahun "+ Marine.getInstance().getBirthDate().getYear() + "hitung sendiri"}));
        trainingModels.add(new NBTrainingModel("personal", "sampai jumpa", new String[]{"dadah"}));

        NBTrainingModelList nbTrainingModelList = new NBTrainingModelList(trainingModels);
        CacheManager.getInstance(context).updateTrainingData(nbTrainingModelList);
    }

    private void initiateLeaveData() {

    }
}
