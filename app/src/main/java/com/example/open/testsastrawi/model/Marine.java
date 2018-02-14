package com.example.open.testsastrawi.model;

import android.content.Context;

import com.example.open.testsastrawi.nlp.SastrawiWrapper;
import com.example.open.testsastrawi.nlp.SimilarityWrapper;
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
    public String getResponse(String category, String inputText) {
        if (category.equals("greetings")) {
            return getGreeting(inputText);
        } else if (category.equals("goodbye")) {
            return "";
        } else if (category.equals("personal")) {
            return "";
        }

        return "Aku g tau km bilang apa";
    }

    public String getGreeting(String input) {
        String[] inputTokens = SastrawiWrapper.getInstance().getTokenizer().tokenize(input.toLowerCase());
        List<String> responses = new ArrayList<>();
        responses.add("Waalaikumussalam");
        responses.add("Halo");
        responses.add("Hai");
        responses.add("ada yang bisa dibantu ?");

        int tokenIndex = 0;
        for (String inputToken: inputTokens) {
            if (SimilarityWrapper.getInstance().calculateDistance(inputToken, "assalamualaikum") <= 3) {
                return responses.get(0);
            } else if (SimilarityWrapper.getInstance().calculateDistance(inputToken, "selamat") <= 2) {
                return "Selamat "+inputTokens[tokenIndex + 1];
            }

            tokenIndex++;
        }

        responses.remove(0);
        int index = new Random().nextInt(3);
        return responses.get(index);
    }

//    public String getPersonalResponse(String input) {
//        String[] inputTokens = SastrawiWrapper.getInstance().getTokenizer().tokenize(input);
//        int tokenIndex = 0;
//        for (String inputToken: inputTokens) {
//            if ()
//        }
//    }


}
