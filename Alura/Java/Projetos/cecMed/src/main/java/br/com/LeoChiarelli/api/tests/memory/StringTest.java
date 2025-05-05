package br.com.LeoChiarelli.api.tests.memory;

public class StringTest {
    public static void main(String[] args) throws InterruptedException {
        String v1 = "Java";
        String v2 = "Java";

        System.out.println(v1 == v2); // Pool de Strings

        var v3 = new String("Java");
        System.out.println(v1 == v3);

        v1 += " Programação"; // Não modificamos quem esta dentro do pool, apenas criamos um novo objeto
        System.out.println(v1);

        StringBuilder v4 = new StringBuilder(); // Para evitar a criação de objetos que não vão ser usados na memória

        for(int i=1; i<= 10; i++){
            v4.append(i).append(" ");
        }

        System.out.println(v4);

        var resultado = new StringBuffer();

        var thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                resultado.append(i).append(" ");
            }
        });

        var thread2 = new Thread(() -> {
            for (int i = 11; i <= 20; i++){
                resultado.append(i).append(" ");
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(resultado);
    }
}
