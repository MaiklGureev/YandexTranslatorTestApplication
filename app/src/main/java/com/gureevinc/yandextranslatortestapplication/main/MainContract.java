package com.gureevinc.yandextranslatortestapplication.main;

import android.app.Activity;
import android.widget.Spinner;

public interface MainContract {

    interface View {
        Spinner getCurrentLanguageSpinner();

        Spinner getTranslatedLanguageSpinner();

        void setTranslatedText(String translatedText);

        Activity getActivity();

        String getTextForTranslation();

        void setTextForTranslation(String textForTranslation);

        String getTranslatedText();

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

    }

}
