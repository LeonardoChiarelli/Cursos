package br.com.LeoChiarelli.api.tests.memory;

public class PCRegistersTest {
    public static void main(String[] args) {
        // PC Registers guardam os endereços das relações entre os metodos java
        System.out.println(soma(9, 7));
        System.out.println(soma(5, 4));
    }

    public native static int soma(int a, int b); // códigos em C++ ou Assembly (de baixo nível)
}
