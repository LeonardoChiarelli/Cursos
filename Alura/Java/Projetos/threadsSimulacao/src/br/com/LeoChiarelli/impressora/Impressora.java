package br.com.LeoChiarelli.impressora;

public class Impressora implements Runnable{

    private int id;

    public Impressora(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Impressora de id " + id + " valor: " + i);
        }
    }
}
