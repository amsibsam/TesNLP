package com.example.open.testsastrawi.nlp.naivebeyesclassifier.training;

import java.util.List;

/**
 * Created by Rahardyan on 12/17/2017.
 */

public class NBTrainingModelList {
    private final List<NBTrainingModel> traningData;

    public NBTrainingModelList(List<NBTrainingModel> traningData) {
        this.traningData = traningData;
    }

    public List<NBTrainingModel> getTraningData() {
        return traningData;
    }
}
