package com.gureevinc.yandextranslatortestapplication.network.POJOs.DetectLanguage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetectLanguageResponsePOJO {
    @SerializedName("languageCode")
    @Expose
    private String languageCode;

    public DetectLanguageResponsePOJO() {
    }

    public DetectLanguageResponsePOJO(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
}
