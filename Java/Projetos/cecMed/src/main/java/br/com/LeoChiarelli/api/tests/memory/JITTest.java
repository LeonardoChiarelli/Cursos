package br.com.LeoChiarelli.api.tests.memory;

public class JITTest {
    public static void main(String[] args) {
        for(int i = 0; i<10000; i++){
            System.out.println(soma(i,  i+3));
        }
    }
    public static int soma(int valor1, int valor2){
        return valor1 + valor2;
    }
}

