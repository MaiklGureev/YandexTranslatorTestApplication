package com.gureevinc.yandextranslatortestapplication.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.gureevinc.yandextranslatortestapplication.R;
import com.gureevinc.yandextranslatortestapplication.Repository;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages.LanguagesRequestPOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages.LanguagesResponsePOJO;
import com.gureevinc.yandextranslatortestapplication.sqlite.TranslationRecord;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gureevinc.yandextranslatortestapplication.StaticVariables.FOLDER_ID;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private String TAG = "MainActivity";

    private MaterialButton translateButton;
    private MaterialButton saveToHistoryButton;
    private MaterialButton switchLanguageButton;
    private MaterialButton defineCurrentLanguageButton;

    private MaterialTextView translatedTextTextView;
    private TextInputEditText textForTranslationEditText;

    private Spinner currentLanguageSpinner;
    private Spinner translatedLanguageSpinner;

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translateButton = findViewById(R.id.translateButton);
        saveToHistoryButton = findViewById(R.id.saveToHistoryButton);
        switchLanguageButton = findViewById(R.id.switchLanguageButton);

        translatedTextTextView = findViewById(R.id.translatedTextTextView);
        textForTranslationEditText = findViewById(R.id.textForTranslationEditText);

        currentLanguageSpinner = findViewById(R.id.currentLanguageSpinner);
        translatedLanguageSpinner = findViewById(R.id.translatedLanguageSpinner);

        textForTranslationEditText.setMovementMethod(new ScrollingMovementMethod());
        presenter = new MainPresenter(this);
        presenter.initSpinners();

    }
    public Spinner getCurrentLanguageSpinner() {
        return currentLanguageSpinner;
    }

    @Override
    public Spinner getTranslatedLanguageSpinner() {
        return translatedLanguageSpinner;
    }


    @Override
    public void setTranslatedText(String translatedText) {
        translatedTextTextView.setText(translatedText);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public String getTextForTranslation() {
        return String.valueOf(textForTranslationEditText.getText());
    }

    @Override
    public void setTextForTranslation(String textForTranslation) {
        textForTranslationEditText.setText(textForTranslation);
    }

    @Override
    public String getTranslatedText() {
        return String.valueOf(translatedTextTextView.getText());
    }

    @Override
    public void showLongToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.switchLanguageButton:{
                presenter.switchLanguageAndTranslate();
                break;
            }case R.id.translateButton:{
                presenter.defineLanguageAndTranslate();
                break;
            }case R.id.saveToHistoryButton:{
                presenter.saveToHistory();
                break;
            }
        }
    }
}
