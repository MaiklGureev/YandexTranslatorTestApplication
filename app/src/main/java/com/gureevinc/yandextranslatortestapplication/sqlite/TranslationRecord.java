package com.gureevinc.yandextranslatortestapplication.sqlite;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "translation_records")
public class TranslationRecord {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String originalText;
    private String translatedText;
    private String originalLanguage;
    private String translatedLanguage;

    public TranslationRecord() {
    }
    @Ignore
    public TranslationRecord(String originalText, String translatedText, String originalLanguage, String translatedLanguage) {
        this.originalText = originalText;
        this.translatedText = translatedText;
        this.originalLanguage = originalLanguage;
        this.translatedLanguage = translatedLanguage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getTranslatedLanguage() {
        return translatedLanguage;
    }

    public void setTranslatedLanguage(String translatedLanguage) {
        this.translatedLanguage = translatedLanguage;
    }

    @Override
    public String toString() {
        return "TranslationRecord{" +
                "id=" + id +
                ", originalText='" + originalText + '\'' +
                ", translatedText='" + translatedText + '\'' +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", translatedLanguage='" + translatedLanguage + '\'' +
                '}';
    }
}
