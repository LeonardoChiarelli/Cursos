package br.com.LeoChiarelli.api.tests.GC;

public class G1Test {
    public static void main(String[] args) {
        Object[] objects = new Object[10000000];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object();
        }

        objects = null;
    }
}
