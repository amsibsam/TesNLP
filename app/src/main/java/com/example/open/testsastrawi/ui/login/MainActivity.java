package com.example.open.testsastrawi.ui.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.open.testsastrawi.R;
import com.example.open.testsastrawi.model.User;
import com.example.open.testsastrawi.nlp.SastrawiWrapper;
import com.example.open.testsastrawi.nlp.naivebeyesclassifier.NaiveBeyesClassifier;
import com.example.open.testsastrawi.storage.CacheManager;
import com.example.open.testsastrawi.ui.chat.ChatActivity;

public class MainActivity extends AppCompatActivity {
    public static String TAG = MainActivity.class.getSimpleName();
    private EditText etUsername;
    private Button btnLogin;

    private String[] words = {
            "Nerjang",
            "Nuduh",
            "Nerima",
            "negur",
            "mukul",
            "Mimpin",
            "nyoba",
            "nyiram",
            "Nyuruh",
            "Nyimpen",
            "Nyebrang",
            "Nganggep",
            "Ngamuk",
            "Ngambil",
            "Ngebuka",
            "Ngebantu",
            "Ngelepas",
            "Kebayang",
            "Keinjek",
            "Kekabul",
            "Kepergok",
            "Ketipu",
            "Keulang",
            "Kewujud",
            "Critain",
            "Betulin",
            "Manjain",
            "Gangguin",
            "Gantian",
            "Ikutan",
            "Musuhan",
            "Sabunan",
            "Temenan",
            "Tukeran",
            "nanyain",
            "nunjukin",
            "mentingin",
            "megangin",
            "nyelametin",
            "nyempetin",
            "ngorbanin",
            "ngadepin",
            "ngebuktiin",
            "ngewarnain",
            "Kedengeran",
            "ketemuan",
            "beneran",
            "ginian",
            "kawinan",
            "mainan",
            "parkiran",
            "duluan",
            "gendutan",
            "karatan",
            "palingan",
            "sabaran",
            "kebagusan",
            "sanaan",
            "cepetan",
            "sepagian"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();

        for (String word: words) {
            Log.d(TAG, "onCreate: stemm result " + word + " > " + SastrawiWrapper.getInstance().getLemmatizer().lemmatize(word));
        }

//        Log.d(TAG, "onCreate: stemm " + SastrawiWrapper.getInstance().getLemmatizer().lemmatize("nerjang"));
    }

    private void setupUI() {
        etUsername = (EditText) findViewById(R.id.et_username);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(etUsername.getText().toString());
                CacheManager.getInstance(MainActivity.this).saveUser(user);

                startActivity(ChatActivity.getInstance(MainActivity.this));
            }
        });
    }

//     Log.d(TAG, "distance: " + SimilarityWrapper.getInstance().calculateDistance("saya", "sataa"));
//                GTranslateWrapper.getInstance().detectLanguage(etUsername.getText().toString(), new GTranslateWrapper.OnDetected() {
//                    @Override
//                    public void onDetected(final String language) {
//                        Log.d(TAG, "onDetected: "+language);
//                        if (!language.equals("id")) {
//                            GTranslateWrapper.getInstance().getTranslatedText(etUsername.getText().toString(), language, "id", new GTranslateWrapper.OnTranslated() {
//                                @Override
//                                public void onTranslated(String text) {
//                                    String stemmedWord = SastrawiWrapper.getInstance().getLemmatizer().lemmatize(text);
//                                    GTranslateWrapper.getInstance().getTranslatedText(stemmedWord, "id", language, new GTranslateWrapper.OnTranslated() {
//                                        @Override
//                                        public void onTranslated(String text) {
//                                            tvOutput.setText(text);
//                                        }
//                                    });
//                                }
//                            });
//                        } else {
//
//                            tvOutput.setText(SastrawiWrapper.getInstance().getLemmatizer().lemmatize(etUsername.getText().toString()));
//                        }
//
//                    }
//                });
}
