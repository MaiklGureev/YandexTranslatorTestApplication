package com.gureevinc.yandextranslatortestapplication.savedHistoryList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.android.material.textview.MaterialTextView;
import com.gureevinc.yandextranslatortestapplication.AlertDialogHelper;
import com.gureevinc.yandextranslatortestapplication.R;
import com.gureevinc.yandextranslatortestapplication.main.MainContract;
import com.gureevinc.yandextranslatortestapplication.sqlite.TranslationRecord;

import java.util.List;

public class SavedHistoryAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<TranslationRecord> translationRecords;
    private MainContract.Presenter presenter;

    public SavedHistoryAdapter(Context context, LayoutInflater layoutInflater, List<TranslationRecord> translationRecords, MainContract.Presenter presenter) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.translationRecords = translationRecords;
        this.presenter = presenter;
    }


    public void setTranslationRecords(List<TranslationRecord> translationRecords) {
        this.translationRecords = translationRecords;
    }

    @Override
    public int getCount() {
        return translationRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return translationRecords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.alert_dialog_item, parent, false);
        }

        MaterialTextView originalLanguage = view.findViewById(R.id.originalLanguageTextView);
        MaterialTextView translatedLanguage = view.findViewById(R.id.translatedLanguageTextView);
        MaterialTextView originalText = view.findViewById(R.id.originalTextTextView);
        MaterialTextView translatedText = view.findViewById(R.id.translatedTextView);

        originalLanguage.setText(context.getString(R.string.originaLanguage) + translationRecords.get(position).getOriginalLanguage());
        translatedLanguage.setText(context.getString(R.string.translatedLanguage) + translationRecords.get(position).getTranslatedLanguage());
        originalText.setText(translationRecords.get(position).getOriginalText());
        translatedText.setText(translationRecords.get(position).getTranslatedText());

        View.OnClickListener translationRecordOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogHelper.showDeleteMessage(context,presenter,
                        SavedHistoryAdapter.this,
                        position);
            }
        };

        view.setOnClickListener(translationRecordOnClickListener);
        return view;
    }

    public List<TranslationRecord> getTranslationRecords() {
        return translationRecords;
    }
}
