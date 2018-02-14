package com.example.open.testsastrawi.nlp.naivebeyesclassifier;

import android.content.Context;
import android.util.Log;

import com.example.open.testsastrawi.nlp.SastrawiWrapper;
import com.example.open.testsastrawi.nlp.SimilarityWrapper;
import com.example.open.testsastrawi.nlp.naivebeyesclassifier.training.NBTrainingDataInstance;
import com.example.open.testsastrawi.nlp.naivebeyesclassifier.training.NBTrainingModel;
import com.example.open.testsastrawi.nlp.naivebeyesclassifier.training.NBTrainingModelList;
import com.example.open.testsastrawi.storage.CacheManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rahardyan on 12/17/2017.
 */

public class NaiveBeyesClassifier {
    private static final String TAG = NaiveBeyesClassifier.class.getSimpleName();
    private static NaiveBeyesClassifier instance;
    private final Context context;

    private NaiveBeyesClassifier(Context context) {
        NBTrainingDataInstance.initDataTraining(context);
        this.context = context;
    }

    public static NaiveBeyesClassifier getInstance(Context context) {
        if (instance == null) {
            instance = new NaiveBeyesClassifier(context);
        }

        return instance;
    }

    public Map.Entry<String, Double> classify(String sentence) {
        // tokenize input sentence to array of word
        String[] inputWords = SastrawiWrapper.getInstance().getTokenizer().tokenize(sentence.toLowerCase());

        // get training model for cache manager
        NBTrainingModelList trainingModelList = CacheManager.getInstance(context).getTrainingData();
        List<NBTrainingModel> traningModels = trainingModelList.getTraningData();

        // create result map <"greeting", 2>
        HashMap<String, Double> resultMap = new HashMap<>();

        // calculate and get highest weight from the data training
        boolean isMatch = false;
        for (NBTrainingModel model : traningModels) {
            List<String> trainingWords = new ArrayList<>(Arrays.asList(SastrawiWrapper.getInstance().getTokenizer().tokenize(model.getSentence())));
            for (String inputWord : inputWords) {
                for (String trainingWord : trainingWords) {
                    if (SimilarityWrapper.getInstance().calculateDistance(inputWord, trainingWord) <= 2) {
                        if (resultMap.containsKey(model.getWordClass())) {
                            double wordValue = resultMap.get(model.getWordClass()); // current weight
                            double wordWeight = (isMatch ? 1.5 : 1.0 / (trainingModelList.getDataSize(model.getWordClass()))); // calculated weight
                            resultMap.put(model.getWordClass(), wordValue + wordWeight);
                        } else {
                            double wordWeight = (isMatch ? 1.5 : 1.0 / (trainingModelList.getDataSize(model.getWordClass()))); // calculated weight
                            resultMap.put(model.getWordClass(), wordWeight);
                        }
                        isMatch = true;
                    }
                }
            }
            isMatch = false;
        }

        Map.Entry<String, Double> highestResult = getHighestValue(resultMap);
        return highestResult;
    }

    private Map.Entry<String, Double> getHighestValue(HashMap<String, Double> map) {
        Map.Entry<String, Double> maxEntry = null;

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry;
    }
}
