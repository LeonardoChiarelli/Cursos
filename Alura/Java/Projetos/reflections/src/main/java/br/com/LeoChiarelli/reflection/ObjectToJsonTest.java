package br.com.LeoChiarelli.reflection;

import br.com.LeoChiarelli.Pessoa;

public class ObjectToJsonTest {
    public static void main(String... x) {
        Pessoa pessoa = new Pessoa(1L, "João", "12345");
        ObjectToJson objectToJson = new ObjectToJson();
        System.out.println(objectToJson.transform(pessoa));
    }
}
