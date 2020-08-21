package com.gureevinc.yandextranslatortestapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.MonitoringInstrumentation;

import com.gureevinc.yandextranslatortestapplication.main.MainActivity;
import com.gureevinc.yandextranslatortestapplication.main.MainPresenter;
import com.gureevinc.yandextranslatortestapplication.sqlite.TranslationRecord;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class AlertDialogHelperTest {

    @Test
    public void showRecordsHistory() {
//        InstrumentationRegistry.getInstrumentation().addMonitor();
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        List<TranslationRecord> translationRecordList = new ArrayList<>();
//        translationRecordList.add(new TranslationRecord("Привет", "Hello", "ru", "en"));
//        translationRecordList.add(new TranslationRecord("Car", "Машина", "en", "ru"));
//        translationRecordList.add(new TranslationRecord("Bee", "Пчела", "en", "ru"));
//        AlertDialogHelper.showRecordsHistory(appContext, LayoutInflater.from(appContext), translationRecordList, new MainPresenter(new MainActivity()));
    }

    @Test
    public void showDeleteMessage() {
    }
}