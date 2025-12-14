package br.com.LeoChiarelli.impressora;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        var im1 = new Impressora(1);
        var im2 = new Impressora(2);

        Thread imprimir1 = new Thread(im1);
        Thread imprimir2 = new Thread(im2);


        imprimir1.setPriority(9); // configurar a prioridade, passando como parâmetro o valor da prioridade que queremos dar à thread, sendo 10 a maior prioridade e 1 a menor prioridade.

        imprimir1.start();

        imprimir1.join();

        var status = imprimir1.isAlive(); //  mostra um boolean, que diz “true” se a thread está ativa, e “false” caso esteja inativa.
        System.out.println(status);


        imprimir2.start();


    }
}
