package com.example.open.testsastrawi.model;

import android.content.Context;

import com.example.open.testsastrawi.nlp.naivebeyesclassifier.training.NBTrainingDataInstance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Rahardyan on 12/16/2017.
 */

public class Marine {
    private static Marine INSTANCE;
    private Context context;

    private final String name;
    private final Date birthDate;
    private final int height;
    private final int weight;
    private final String gender;
    private final String status;

    private Marine(Context context) {
        this.name = "Marine";
        this.birthDate = new Date(2017, 12, 11);
        this.height = 160;
        this.weight = 46;
        this.gender = "perempuan";
        this.status = "complicated";
        this.context = context;
    }

    public static void init(Context context) {
        INSTANCE = new Marine(context);
        NBTrainingDataInstance.initDataTraining(context);
    }

    public static Marine getInstance() {
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

//    public String proccessInput(String inputText) {
//
//    }

    public String getGreeting(String initialText) {
        List<String> responses = new ArrayList<>();
        responses.add("Waalaikumussalam");
        responses.add("Halo");
        responses.add("Hai");
        responses.add("ada yang bisa dibantu ?");

        if (initialText.toLowerCase().contains("assalamualaikum") || initialText.toLowerCase().contains("assalamualaykum")) {
            return responses.get(0);
        } else {
            responses.remove(0);
            int index = new Random().nextInt(2);
            return responses.get(index);
        }
    }

    public String getResponse(String input) {
        if (input.toLowerCase().contains("siapa") && (input.toLowerCase().contains("nama") ||
                input.toLowerCase().contains("namamu") ||
                input.toLowerCase().contains("nama mu")||
                (input.toLowerCase().contains("siapa") && (input.toLowerCase().contains("kamu") ||
                        input.toLowerCase().contains("anda" ) || input.toLowerCase().contains("dirimu") ||
                        input.toLowerCase().contains("kau"))))) {
            List<String> response = new ArrayList<>();
            response.add("Nama saya");
            response.add("saya");
            response.add("");

            int index = new Random().nextInt(2);
            return (response.get(index) + " " + getName()).trim();
        } else {
            return "";
        }
    }
}
