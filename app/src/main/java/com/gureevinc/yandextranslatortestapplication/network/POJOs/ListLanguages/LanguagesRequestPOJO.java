package com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguagesRequestPOJO {
    @SerializedName("folder_id")
    @Expose
    private String folder_id;

    public LanguagesRequestPOJO() {
    }

    public LanguagesRequestPOJO(String folder_id) {
        this.folder_id = folder_id;
    }

    public String getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(String folder_id) {
        this.folder_id = folder_id;
    }
}
