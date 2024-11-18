package br.com.LeoChiarelli.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.net.URLEncoder;

public class ConsultMyMemory {
    public static String getTranslation(String text){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        APIconsumption consumption = new APIconsumption();

        String txt = URLEncoder.encode(text);
        String langpair = URLEncoder.encode("en|pt-br");

        String url = "https://api.mymemory.translated.net/get?q=" + txt + "&langpair=" + langpair;

        String json = consumption.getData(url);

        TranslateData translation;
        try {
            translation = gson.fromJson(json, TranslateData.class);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
        return translation.responseData().translatedText();
    }
}
