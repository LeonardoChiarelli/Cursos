package br.com.LeoChiarelli.adopet.main;

import br.com.LeoChiarelli.adopet.command.*;

import java.util.Scanner;

public class Main {
    public void displayMenu(){
        var executor =  new CommandExecutor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####\n");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                System.out.print("""
                        ****************************************
                        \s
                        1 -> Listar abrigos cadastrados
                        2 -> Cadastrar novo abrigo
                        3 -> Listar pets do abrigo
                        4 -> Importar pets do abrigo
                        5 -> Sair
                        \s
                        ****************************************
                        DIGITE O NÚMERO DA OPERAÇÃO DESEJADA:\s""");

                opcaoEscolhida = scanner.nextInt();

                switch (opcaoEscolhida) {
                    case 1 -> executor.executeCommand(new ListarAbrigosCadastradosCommand());
                    case 2 -> executor.executeCommand(new CadastrarNovoAbrigoCommand());
                    case 3 -> executor.executeCommand(new ListarPetsDoAbrigoCommand());
                    case 4 -> executor.executeCommand(new ImportarPetsDoAbrigoCommand());
                    case 5 -> System.out.println("Finalizando programa...");
                    default -> System.out.println("Opção inválida!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

