package com.gureevinc.yandextranslatortestapplication.network.POJOs.DetectLanguage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetectLanguageRequestPOJO {

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("languageCodeHints")
    @Expose
    private List<String> languageCodeHints;

    @SerializedName("folderId")
    @Expose
    private String folderId;

    public DetectLanguageRequestPOJO() {
    }

    public DetectLanguageRequestPOJO(String text, List<String> languageCodeHints, String folderId) {
        this.text = text;
        this.languageCodeHints = languageCodeHints;
        this.folderId = folderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getLanguageCodeHints() {
        return languageCodeHints;
    }

    public void setLanguageCodeHints(List<String> languageCodeHints) {
        this.languageCodeHints = languageCodeHints;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }
}
