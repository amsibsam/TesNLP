package com.example.open.testsastrawi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String TAG = MainActivity.class.getSimpleName();
    private EditText etInput;
    private TextView tvOutput;
    private Button btnStem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        etInput = (EditText) findViewById(R.id.et_input);
        tvOutput = (TextView) findViewById(R.id.tv_output);
        btnStem = (Button) findViewById(R.id.btn_stem);

        btnStem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "distance: " + SimilarityWrapper.getInstance().calculateDistance("saya", "sataa"));
                GTranslateWrapper.getInstance().detectLanguage(etInput.getText().toString(), new OnDetected() {
                    @Override
                    public void onDetected(final String language) {
                        Log.d(TAG, "onDetected: "+language);
                        if (!language.equals("id")) {
                            GTranslateWrapper.getInstance().getTranslatedText(etInput.getText().toString(), language, "id", new OnTranslated() {
                                @Override
                                public void onTranslated(String text) {
                                    String stemmedWord = SastrawiWrapper.getInstance().getLemmatizer().lemmatize(text);
                                    GTranslateWrapper.getInstance().getTranslatedText(stemmedWord, "id", language, new OnTranslated() {
                                        @Override
                                        public void onTranslated(String text) {
                                            tvOutput.setText(text);
                                        }
                                    });
                                }
                            });
                        } else {

                            tvOutput.setText(SastrawiWrapper.getInstance().getLemmatizer().lemmatize(etInput.getText().toString()));
                        }

                    }
                });
            }
        });
    }
}
