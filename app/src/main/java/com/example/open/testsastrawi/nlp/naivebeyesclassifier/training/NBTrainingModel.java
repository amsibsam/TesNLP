package com.example.open.testsastrawi.nlp.naivebeyesclassifier.training;

/**
 * Created by Rahardyan on 12/17/2017.
 */

public class NBTrainingModel {
    private final String wordClass;
    private final String sentence;
    private final int weight;

    public NBTrainingModel(String wordClass, String sentence, int weight) {
        this.wordClass = wordClass;
        this.sentence = sentence;
        this.weight = weight;
    }

    public String getWordClass() {
        return wordClass;
    }

    public String getSentence() {
        return sentence;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        NBTrainingModel aNBTrainingModel = (NBTrainingModel) obj;
        return wordClass.equals(aNBTrainingModel.getWordClass()) && sentence.equals(aNBTrainingModel.getSentence());
    }
}
