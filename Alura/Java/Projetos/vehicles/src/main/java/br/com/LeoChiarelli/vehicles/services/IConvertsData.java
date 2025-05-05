package br.com.LeoChiarelli.vehicles.services;

import java.util.List;

public interface IConvertsData {
    <T> T getData(String json, Class<T> tClass);

    <T> List<T> getList(String json, Class<T> tClass);
}
