package br.com.LeoChiarelli.service;

public interface IConvertsData {
    <T> T getData(String json, Class<T> Tclass); // segundo parâmetro é onde vamos informar o tipo de devolução que queremos
}

/*
    '<T> T' - informa ao java que não sabemos o que o metodo vai retornar, mais conhecido como 'generics'
 */
