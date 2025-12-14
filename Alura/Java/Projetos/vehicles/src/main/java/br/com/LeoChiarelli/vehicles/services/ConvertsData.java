package br.com.LeoChiarelli.vehicles.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ConvertsData implements  IConvertsData{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public <T> T getData(String json, Class<T> Tclass) {
        return gson.fromJson(json, Tclass);
    }

    @Override
    public <T> List<T> getList(String json, Class<T> tClass) {
        Type list = TypeToken.getParameterized(List.class, tClass).getType();
        return gson.fromJson(json, list);
    }
}

