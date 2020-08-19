package com.gureevinc.yandextranslatortestapplication.network.POJOs.Translate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TranslateRequestPOJO {

    @SerializedName("folder_id")
    @Expose
    private String folderId;

    @SerializedName("texts")
    @Expose
    private List<String> texts;

    @SerializedName("targetLanguageCode")
    @Expose
    private String targetLanguageCode;

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public List<String> getTexts() {
        return texts;
    }

    public void setTexts(List<String> texts) {
        this.texts = texts;
    }

    public TranslateRequestPOJO() {
    }

    public TranslateRequestPOJO(String folderId, List<String> texts, String targetLanguageCode) {
        this.folderId = folderId;
        this.texts = texts;
        this.targetLanguageCode = targetLanguageCode;
    }

    public String getTargetLanguageCode() {
        return targetLanguageCode;
    }

    public void setTargetLanguageCode(String targetLanguageCode) {
        this.targetLanguageCode = targetLanguageCode;
    }
}
