package com.example.open.testsastrawi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import jsastrawi.morphology.DefaultLemmatizer;
import jsastrawi.morphology.Lemmatizer;

/**
 * Created by Rahardyan on 12/1/2017.
 */

public class SastrawiWrapper {
    private static SastrawiWrapper instance = new SastrawiWrapper();
    private Lemmatizer lemmatizer;

    public static SastrawiWrapper getInstance() {
        return instance;
    }

    private SastrawiWrapper() {}

    public void init() {
        //        initialize dictionary
        Set<String> dictionary = new HashSet<String>();

        InputStream in = Lemmatizer.class.getResourceAsStream("/root-words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        try {
            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        lemmatizer = new DefaultLemmatizer(dictionary);
    }

    public Lemmatizer getLemmatizer() {
        return this.lemmatizer;
    }
}
