package com.gureevinc.yandextranslatortestapplication.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.provider.Settings;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.gureevinc.yandextranslatortestapplication.DataProcessingTools;
import com.gureevinc.yandextranslatortestapplication.R;
import com.gureevinc.yandextranslatortestapplication.Repository;
import com.gureevinc.yandextranslatortestapplication.StaticVariables;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.DetectLanguage.DetectLanguageRequestPOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.DetectLanguage.DetectLanguageResponsePOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages.LanguagesRequestPOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages.LanguagesResponsePOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.Translate.TranslateRequestPOJO;
import com.gureevinc.yandextranslatortestapplication.network.POJOs.Translate.TranslateResponsePOJO;
import com.gureevinc.yandextranslatortestapplication.sqlite.TranslationRecord;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private Repository repository;
    private List<LanguagesResponsePOJO.Languages> languagesList = new ArrayList<>();
    private List<String> languagesCodesList = new ArrayList<>();

    public MainPresenter(MainContract.View view) {
        this.view = view;
        repository = Repository.getInstance(view.getActivity().getApplicationContext());
    }

    public void translate() {
        if (view.getCurrentLanguageSpinner().getSelectedItem() != null && !view.getTextForTranslation().isEmpty()) {

            final String textForTranslation = view.getTextForTranslation();
            String translatedLanguageCode = ((LanguagesResponsePOJO.Languages) (view.getTranslatedLanguageSpinner().getSelectedItem())).getCode();

            TranslateRequestPOJO translateRequestPOJO = new TranslateRequestPOJO();
            translateRequestPOJO.setFolderId(StaticVariables.FOLDER_ID);
            translateRequestPOJO.setTargetLanguageCode(translatedLanguageCode);
            translateRequestPOJO.setTexts(DataProcessingTools.splitText(textForTranslation));

            repository.getNetworkService()
                    .getJsonPlaceHolderApi()
                    .getTranslation(translateRequestPOJO)
                    .enqueue(new Callback<TranslateResponsePOJO>() {
                        @Override
                        public void onResponse(Call<TranslateResponsePOJO> call, Response<TranslateResponsePOJO> response) {
                            if (response.code() == 200) {
                                List<TranslateResponsePOJO.StringTranslations> result = response.body().getTranslations();
                                String text = "";
                                for (TranslateResponsePOJO.StringTranslations stringTranslations : result) {
                                    text += stringTranslations.getText();
                                    if (result.size() > 1 && result.indexOf(stringTranslations) != result.size() - 1) {
                                        text += "\n";
                                    }
                                }
                                view.setTranslatedText(text);
                            } else {
                                view.showLongToast(String.valueOf(response.code()));
                            }


                        }

                        @Override
                        public void onFailure(Call<TranslateResponsePOJO> call, Throwable t) {
                            String message = view.getActivity().getString(R.string.translateError);
                            view.showLongToast(message);
                        }
                    });
        }

    }

    @Override
    public void saveToHistory() {
        if (view.getCurrentLanguageSpinner().getSelectedItem() != null) {

            final TranslationRecord translationRecord = new TranslationRecord();
            translationRecord.setOriginalLanguage(view.getCurrentLanguageSpinner().getSelectedItem().toString());
            translationRecord.setOriginalText(view.getTextForTranslation());
            translationRecord.setTranslatedLanguage(view.getTranslatedLanguageSpinner().getSelectedItem().toString());
            translationRecord.setTranslatedText(view.getTranslatedText());

            @SuppressLint("StaticFieldLeak") AsyncTask saveToHistoryAsyncTask = new AsyncTask() {

                @Override
                protected Object doInBackground(Object[] objects) {
                    repository.getRoomDB().recordDAO().insertRecord(translationRecord);
                    return null;
                }

                @Override
                protected void onCancelled() {
                    super.onCancelled();
                    String message = view.getActivity().getString(R.string.insertError);
                    view.showLongToast(message);
                }
            };

            saveToHistoryAsyncTask.execute();
        }
    }


    @Override
    public void defineLanguageAndTranslate() {
        DetectLanguageRequestPOJO detectLanguageRequestPOJO = new DetectLanguageRequestPOJO();
        detectLanguageRequestPOJO.setFolderId(StaticVariables.FOLDER_ID);
        detectLanguageRequestPOJO.setLanguageCodeHints(languagesCodesList);
        detectLanguageRequestPOJO.setText(view.getTextForTranslation());

        repository.getNetworkService()
                .getJsonPlaceHolderApi()
                .getLanguageCode(detectLanguageRequestPOJO)
                .enqueue(new Callback<DetectLanguageResponsePOJO>() {
                    @Override
                    public void onResponse(Call<DetectLanguageResponsePOJO> call, Response<DetectLanguageResponsePOJO> response) {
                        if (response.code() == 200) {
                            String languageCode = response.body().getLanguageCode();

                            int translatedIdLanguageCode = view.getTranslatedLanguageSpinner().getSelectedItemPosition();
                            int currentIdLanguageCode = view.getCurrentLanguageSpinner().getSelectedItemPosition();
                            int languageId = DataProcessingTools.getLanguageIdByCode(languageCode, languagesList);

                            Log.d("defineLangAndTr", "onResponse: translatedIdLanguageCode" + translatedIdLanguageCode);
                            Log.d("defineLangAndTr", "onResponse: currentIdLanguageCode" + currentIdLanguageCode);
                            Log.d("defineLangAndTr", "onResponse: languageId" + translatedIdLanguageCode);

                            translate();
                            if(currentIdLanguageCode!=languageId){
                                view.getCurrentLanguageSpinner().setSelection(languageId);
                            }



                        } else {
                            String message = view.getActivity().getString(R.string.defineLanguageError);
                            view.showLongToast(message);
                        }
                    }

                    @Override
                    public void onFailure(Call<DetectLanguageResponsePOJO> call, Throwable t) {

                    }
                });
    }

    @Override
    public void initSpinners() {
        if (languagesList.isEmpty()) {
            repository.getNetworkService()
                    .getJsonPlaceHolderApi()
                    .getLanguages(new LanguagesRequestPOJO(StaticVariables.FOLDER_ID))
                    .enqueue(new Callback<LanguagesResponsePOJO>() {
                        @Override
                        public void onResponse(Call<LanguagesResponsePOJO> call, Response<LanguagesResponsePOJO> response) {
                            if (response.code() == 200) {
                                languagesList = response.body().getLanguages();
                                languagesCodesList = DataProcessingTools.getLanguagesCods(languagesList);

                                ArrayAdapter<LanguagesResponsePOJO.Languages> arrayAdapter =
                                        new ArrayAdapter<>(view.getActivity(), android.R.layout.simple_spinner_item, languagesList);

                                view.getCurrentLanguageSpinner().setAdapter(arrayAdapter);
                                view.getTranslatedLanguageSpinner().setAdapter(arrayAdapter);

                                view.getCurrentLanguageSpinner().setSelection(60);
                                view.getTranslatedLanguageSpinner().setSelection(3);
                            } else {
                                view.showLongToast(String.valueOf(response.code()));
                            }
                        }

                        @Override
                        public void onFailure(Call<LanguagesResponsePOJO> call, Throwable t) {
                            String message = view.getActivity().getString(R.string.initSpinnersError);
                            view.showLongToast(message);
                        }
                    });
        }
    }

    @Override
    public void switchLanguageAndTranslate() {
        switchLanguages();
        if (!view.getTranslatedText().isEmpty()){
            view.setTextForTranslation(view.getTranslatedText());
            view.setTranslatedText("");
            defineLanguageAndTranslate();
        }

    }

    public void switchLanguages() {
        int a = view.getCurrentLanguageSpinner().getSelectedItemPosition();
        int b = view.getTranslatedLanguageSpinner().getSelectedItemPosition();

        view.getCurrentLanguageSpinner().setSelection(b);
        view.getTranslatedLanguageSpinner().setSelection(a);
    }


}
