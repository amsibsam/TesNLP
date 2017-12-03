package com.example.open.testsastrawi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import info.debatty.java.stringsimilarity.Levenshtein;
import jsastrawi.morphology.Lemmatizer;

/**
 * Created by Rahardyan on 12/3/2017.
 */

public class SimilarityWrapper {
    private static final SimilarityWrapper instance = new SimilarityWrapper();
    private Levenshtein levenshteinSimilarity;
    private List<String> dictionary;

    private SimilarityWrapper() {
        this.levenshteinSimilarity = new Levenshtein();
    }

    public void init() {
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
        return instance;
    }

    public double calculateDistance(String s1, String s2) {
        return this.levenshteinSimilarity.distance(s1, s2);
    }
}