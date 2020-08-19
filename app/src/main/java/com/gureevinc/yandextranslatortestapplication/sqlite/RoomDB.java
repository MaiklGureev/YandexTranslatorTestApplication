package com.gureevinc.yandextranslatortestapplication.sqlite;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {TranslationRecord.class},version = 1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    public abstract TranslationRecordDAO recordDAO();

}
