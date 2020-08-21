package com.gureevinc.yandextranslatortestapplication;

import com.gureevinc.yandextranslatortestapplication.network.POJOs.ListLanguages.LanguagesResponsePOJO;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DataProcessingToolsTest {

    @Test
    public void splitText() {
        String s = "12345\n54321\n00000";
        List<String> stringList = DataProcessingTools.splitText(s);
        assertEquals(stringList.size(),3);
        assertEquals(stringList.get(1),"54321");

    }

    @Test
    public void getLanguagesCods() {
        List<LanguagesResponsePOJO.Languages> languagesList = new ArrayList<>();
        languagesList.add(new LanguagesResponsePOJO.Languages("fr","french"));
        languagesList.add(new LanguagesResponsePOJO.Languages("ru","russian"));
        languagesList.add(new LanguagesResponsePOJO.Languages("en","english"));
        List<String> stringList = DataProcessingTools.getLanguagesCods(languagesList);
        assertEquals(languagesList.size(),stringList.size());
        assertEquals(languagesList.get(1).getCode(),stringList.get(1));
    }

    @Test
    public void getLanguageIdByCode() {
        String languageCode = "ru";
        List<LanguagesResponsePOJO.Languages> languagesList = new ArrayList<>();
        languagesList.add(new LanguagesResponsePOJO.Languages("fr","french"));
        languagesList.add(new LanguagesResponsePOJO.Languages("ru","russian"));
        languagesList.add(new LanguagesResponsePOJO.Languages("en","english"));
        int id = DataProcessingTools.getLanguageIdByCode(languageCode,languagesList);
        assertEquals("Russian language code must be id 1",1,id);
        languageCode = "brrr";
        id = DataProcessingTools.getLanguageIdByCode(languageCode,languagesList);
        assertEquals("If language code not found must be id -1",-1,id);
    }
}