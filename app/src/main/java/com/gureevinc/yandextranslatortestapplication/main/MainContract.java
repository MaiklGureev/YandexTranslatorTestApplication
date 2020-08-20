package com.gureevinc.yandextranslatortestapplication.main;

import android.app.Activity;
import android.widget.Spinner;

import com.gureevinc.yandextranslatortestapplication.sqlite.TranslationRecord;

public interface MainContract {

    interface View {
        //получение спинера языка ввода
        Spinner getCurrentLanguageSpinner();

        //получение спинера языка для перевода
        Spinner getTranslatedLanguageSpinner();

        //установить переведённый текст
        void setTranslatedText(String translatedText);

        //получить ссылку на активити
        Activity getActivity();

        //получить текст для перевода
        String getTextForTranslation();

        //установить текст для превода
        void setTextForTranslation(String textForTranslation);

        //получить переведённый текст
        String getTranslatedText();

        //показать длинное уведомление
        void showLongToast(String text);

    }

    interface Presenter {

        //сохранение перевода в историю
        void saveToHistory();

        //загрузка списка языков спинеры
        void initSpinners();

        //переключение языка и перевод
        void switchLanguageAndTranslate();

        //определение языка и первод текста
        void defineLanguageAndTranslate();

        //показать диалоговое окно с историей переводов
        void showAlertDialogWithTranslatedHistory();

        void deleteTranslatedRecord(TranslationRecord translationRecord);
    }

}
