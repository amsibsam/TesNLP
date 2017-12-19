package com.example.open.testsastrawi.nlp;


import android.os.AsyncTask;
import android.util.Log;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by Rahardyan on 12/2/2017.
 */
public class GTranslateWrapper {
    private static GTranslateWrapper instance = new GTranslateWrapper();

    private GTranslateWrapper() {
    }

    public static GTranslateWrapper getInstance() {
        return instance;
    }

    public void getTranslatedText(final String text, final String sourceLang, final String targetLang, final OnTranslated listener) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                Translation translation = TranslateOptions.newBuilder().setApiKey("AIzaSyDwE6zA_8DOX2WxRmoo1h09jejVpz-RcB0").build().getService().translate(text, Translate.TranslateOption.sourceLanguage(sourceLang), Translate.TranslateOption.targetLanguage(targetLang));
                Log.d("translated", "onTextChanged: "+translation.getTranslatedText());

                return translation.getTranslatedText();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                listener.onTranslated(s);
            }
        }.execute();
    }

    public void detectLanguage(final String sourceText, final OnDetected listener) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                String result = "";
                Translate translate = TranslateOptions.newBuilder().setApiKey("AIzaSyDwE6zA_8DOX2WxRmoo1h09jejVpz-RcB0").build().getService();
                List<Detection> detections = translate.detect(ImmutableList.of(sourceText));

                for (Detection detection : detections) {
                    if (detection.getConfidence() > 0.5) {
                        Log.d("detection", detection.getLanguage());
                        result = detection.getLanguage();
                        break;
                    }
                }
                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                listener.onDetected(s);
            }
        }.execute();
    }

    public interface OnTranslated {
        void onTranslated(String text);
    }

    public interface OnDetected {
        void onDetected(String language);
    }
}
