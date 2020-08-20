package com.gureevinc.yandextranslatortestapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.gureevinc.yandextranslatortestapplication.main.MainContract;
import com.gureevinc.yandextranslatortestapplication.savedHistoryList.SavedHistoryAdapter;
import com.gureevinc.yandextranslatortestapplication.sqlite.TranslationRecord;

import java.util.List;

public class AlertDialogHelper {

    public static void showRecordsHistory(Context context,
                                          LayoutInflater layoutInflater,
                                          List<TranslationRecord> translationRecordList,
                                          MainContract.Presenter presenter) {

        SavedHistoryAdapter savedHistoryAdapter
                = new SavedHistoryAdapter(
                context,
                layoutInflater,
                translationRecordList,
                presenter);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View alertDialogView = layoutInflater.inflate(R.layout.alert_dialog_layout, null);
        ListView listView = alertDialogView.findViewById(R.id.alertDialogListView);
        listView.setAdapter(savedHistoryAdapter);

        if (translationRecordList.isEmpty()) {
            builder.setMessage(R.string.listOfRecordsIsEmpty)
                    .setPositiveButton(R.string.close, null);
        } else {
            builder.setTitle(R.string.history)
                    .setView(alertDialogView);
        }

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void showDeleteMessage(final Context context,
                                         final MainContract.Presenter presenter,
                                         final SavedHistoryAdapter savedHistoryAdapter,
                                         final int index) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.deleteTranslatedRecord(savedHistoryAdapter.getTranslationRecords().get(index));
                savedHistoryAdapter.getTranslationRecords().remove(index);
                savedHistoryAdapter.notifyDataSetChanged();
            }
        };

        builder.setTitle(R.string.questionDeleteRecode)
                .setPositiveButton("Ok", onClickListener)
                .setNegativeButton("Cancel", null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
