package br.com.LeoChiarelli.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ConvertsData implements IConvertsData{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public <T> T getData(String json, Class<T> Tclass) {
        return gson.fromJson(json, Tclass);
    }
}
