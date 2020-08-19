package com.gureevinc.yandextranslatortestapplication.sqlite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TranslationRecordDAO {

    @Query("select * from translation_records")
    List<TranslationRecord> getAllTranslationRecords();

    @Delete
    void deleteRecord(TranslationRecord translationRecord);

    @Insert
    void insertRecord(TranslationRecord translationRecord);

}
