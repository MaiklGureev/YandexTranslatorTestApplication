package com.gureevinc.yandextranslatortestapplication.network.POJOs.Translate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TranslateResponsePOJO {

    @SerializedName("translations")
    @Expose
    private List<StringTranslations> translations;

    public List<StringTranslations> getTranslations() {
        return translations;
    }

    public void setTranslations(List<StringTranslations> translations) {
        this.translations = translations;
    }

    public class StringTranslations{
        @SerializedName("text")
        @Expose
        private String text;

        @SerializedName("detectedLanguageCode")
        @Expose
        private String detectedLanguageCode;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getDetectedLanguageCode() {
            return detectedLanguageCode;
        }

        public void setDetectedLanguageCode(String detectedLanguageCode) {
            this.detectedLanguageCode = detectedLanguageCode;
        }

        @Override
        public String toString() {
            return "StringTranslations{" +
                    "text='" + text + '\'' +
                    ", detectedLanguageCode='" + detectedLanguageCode + '\'' +
                    '}';
        }
    }
}
