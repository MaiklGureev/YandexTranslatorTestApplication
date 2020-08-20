package com.gureevinc.yandextranslatortestapplication.main;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.gureevinc.yandextranslatortestapplication.R;


public class MainActivity extends AppCompatActivity implements MainContract.View {

    private String TAG = "MainActivity";

    private MaterialButton translateButton;
    private MaterialButton saveToHistoryButton;
    private MaterialButton switchLanguageButton;

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
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.switchLanguageButton: {
                presenter.switchLanguageAndTranslate();
                break;
            }
            case R.id.translateButton: {
                presenter.defineLanguageAndTranslate();
                break;
            }
            case R.id.saveToHistoryButton: {
                presenter.saveToHistory();
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.showHistoryItemMenu: {
                presenter.showAlertDialogWithTranslatedHistory();
                return true;
            }
            case R.id.exitItemMenu: {
                finish();
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}
