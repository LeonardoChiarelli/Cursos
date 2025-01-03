package br.com.LeoChiarelli.screenMatch.modelo01;

public class Main{
    public static void main(String[] args){
        System.out.println("Este é o Screen Match\n");

        String nomeDoFilme = "Top Gun: Maverick"; // String
        System.out.println("Filme: " + nomeDoFilme);

        int anoDeLancamento = 2022; // Inteiros; Geramente em empresas o nome das variáveis são em inglês
        System.out.println("Ano de lançamento: " + anoDeLancamento); // Concatenção em Java "+"
        if (anoDeLancamento >= 2023){
            System.out.println("Lançamentos que os clientes estão curtindo!");
        } else if (anoDeLancamento <= 2000) {
            System.out.println("Filmes retrô mais curtidos pelos clientes!");
        } else {
            System.out.println("Filmes que você talvez possa gostar!");
        }

        boolean inclusoNoPlano = false;// Booleanos
        String tipoPlano = "Basic";
        if (!inclusoNoPlano || tipoPlano.equals("Plus")){
            System.out.printf("""
                Necessita de Assinatura? Sim
                Cliente com o plano '%s', não há cobranças adicionais
                """, tipoPlano);
        } else if (!inclusoNoPlano && !tipoPlano.equals("Plus")) { // Usamos o '!' para negar toda a expressão
            System.out.printf("""
                    Necessita de assinatura? Sim
                    Cliente com o plano 'Basic', há uma cobrança de R$19,99
                    """, tipoPlano);
        } else{
            System.out.println("Necessita de Assinatura? Não");
        }

        /* double notaDoFilme = 8.2; // Decimais
        System.out.println("Nota do filme: " + notaDoFilme + "/10"); */

        double media = (9.8 + 6.3 + 8.0) / 3; // Existe a precedência matemática
        System.out.printf("Média das notas: %.2f/10\n", media);

        String sinopse = "Filme de aventura com galã dos anos 80";
        System.out.println("Sinópse: " + sinopse);

        int classificacao = (int) (media/2); // Casting (conversão de tipos)
        System.out.println("Classificação: " + classificacao + "/5");

        /*
            TEXT BLOCK:
                Colocar o texto da maneira que você deseja dentro de aspas triplas (""" """)
        */

        /*
            FORMATTED:
                Metodo que permite formatar o texto direto
        */

        /*
            Em java podemos concatenar variáveis de diferentes tipos, string + int
         */

    }
}