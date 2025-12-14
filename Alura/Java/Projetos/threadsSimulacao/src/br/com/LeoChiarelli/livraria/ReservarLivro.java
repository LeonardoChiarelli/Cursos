package br.com.LeoChiarelli.livraria;

public class ReservarLivro implements Runnable{

    private Livro livro;

    public ReservarLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public synchronized void run() {
        System.out.println("Iniciando reservado");

        if (!livro.getReservado()){
            livro.reservar();
            System.out.println("Reserva realizada com sucesso, aproveite seu livro " + Thread.currentThread().getName());
        } else{
            System.out.println("O livro '" + livro.getNome() + "' ja foi reservado " + Thread.currentThread().getName());
        }
    }
}
