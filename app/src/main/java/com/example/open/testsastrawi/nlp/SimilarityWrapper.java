package com.example.open.testsastrawi.nlp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import info.debatty.java.stringsimilarity.Levenshtein;

/**
 * Created by Rahardyan on 12/3/2017.
 */

public class SimilarityWrapper {
    private static final String TAG = SimilarityWrapper.class.getSimpleName();
    private static SimilarityWrapper instance = new SimilarityWrapper();
    private Levenshtein levenshteinSimilarity;
    private List<String> dictionary = new ArrayList<>();

    private SimilarityWrapper() {
        this.levenshteinSimilarity = new Levenshtein();
        initDictionary();
    }

    private void initDictionary() {
        if (instance != null) {
            Log.d(TAG, "init: cant init more than one");
        }
        InputStream in = SimilarityWrapper.class.getResourceAsStream("/root-words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        try {
            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SimilarityWrapper getInstance() {
        if (instance == null) {
            try {
                throw new Exception("call init() before getInstance");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    public double calculateDistance(String s1, String s2) {
        return this.levenshteinSimilarity.distance(s1, s2);
    }
}