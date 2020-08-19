package com.gureevinc.yandextranslatortestapplication;

import com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages.LanguagesResponsePOJO;

import java.util.ArrayList;
import java.util.List;

public class DataProcessingTools {
    public static List<String> splitText(String text) {
        List<String> stringList = new ArrayList<>();
        String[] strings = text.split("\n");
        for (String s : strings) {
            stringList.add(s);
        }
        return stringList;
    }

    public static List<String> getLanguagesCods(List<LanguagesResponsePOJO.Languages> languagesList) {
        List<String> stringList = new ArrayList<>();

        for (LanguagesResponsePOJO.Languages languages : languagesList) {
            stringList.add(languages.getCode());
        }
        return stringList;
    }

    public static int getLanguageIdByCode(String languageCode, List<LanguagesResponsePOJO.Languages> languagesList){
        int id= -1;
        for (int a = 0; a<languagesList.size();a++) {
            if(languagesList.get(a).getCode().equals(languageCode)){
                id = a;
                return id;
            }
        }
        return id;
    }

}
