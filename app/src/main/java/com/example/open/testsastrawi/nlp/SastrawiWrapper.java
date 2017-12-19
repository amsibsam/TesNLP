package com.example.open.testsastrawi.nlp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import jsastrawi.morphology.DefaultLemmatizer;
import jsastrawi.morphology.Lemmatizer;

/**
 * Created by Rahardyan on 12/1/2017.
 */

public class SastrawiWrapper {
    private static SastrawiWrapper instance;
    private Lemmatizer lemmatizer;

    public static SastrawiWrapper getInstance() {
        if (instance == null) {
            try {
                throw new Exception("call init first");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    private SastrawiWrapper() {
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

    public static void init() throws Exception {
        if (instance != null) {
            instance = new SastrawiWrapper();
        } else {
            throw new Exception("cant init more than one");
        }
        //        initialize dictionary
    }

    public Lemmatizer getLemmatizer() {
        return this.lemmatizer;
    }
}
