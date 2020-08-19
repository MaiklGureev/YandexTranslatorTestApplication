package com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LanguagesResponsePOJO {

    @SerializedName("languages")
    @Expose
    private List<Languages> languages;

    public LanguagesResponsePOJO() {
    }

    public LanguagesResponsePOJO(List<Languages> languages) {
        this.languages = languages;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public static class Languages {
        @SerializedName("code")
        @Expose
        private String code;

        @SerializedName("name")
        @Expose
        private String name;

        public Languages() {
        }

        public Languages(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

    }
}
