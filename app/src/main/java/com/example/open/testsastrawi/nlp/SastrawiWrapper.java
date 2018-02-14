package com.example.open.testsastrawi.nlp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import jsastrawi.morphology.DefaultLemmatizer;
import jsastrawi.morphology.Lemmatizer;
import jsastrawi.tokenization.HeuristicTokenizer;
import jsastrawi.tokenization.Tokenizer;

/**
 * Created by Rahardyan on 12/1/2017.
 */

public class SastrawiWrapper {
    private static final String TAG = SastrawiWrapper.class.getSimpleName();
    private static SastrawiWrapper instance = new SastrawiWrapper();
    private Lemmatizer lemmatizer;
    private Tokenizer tokenizer;

    public static SastrawiWrapper getInstance() {
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
        tokenizer = new HeuristicTokenizer();
    }

    public Tokenizer getTokenizer() {
        return this.tokenizer;
    }
    public Lemmatizer getLemmatizer() {
        return this.lemmatizer;
    }
}
