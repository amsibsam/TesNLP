package com.example.open.testsastrawi.nlp.naivebeyesclassifier.training;

/**
 * Created by Rahardyan on 12/17/2017.
 */

public class NBTrainingModel {
    private final String wordClass;
    private final String sentence;
    private final String[] response;

    public NBTrainingModel(String wordClass, String sentence, String[] response) {
        this.wordClass = wordClass;
        this.sentence = sentence;
        this.response = response;
    }
}
