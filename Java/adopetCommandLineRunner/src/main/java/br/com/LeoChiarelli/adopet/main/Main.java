package br.com.LeoChiarelli.adopet.main;

import br.com.LeoChiarelli.adopet.client.ClientHttpConfiguration;
import br.com.LeoChiarelli.adopet.service.AbrigoService;
import br.com.LeoChiarelli.adopet.service.PetService;

import java.util.Scanner;

public class Main {
    public void displayMenu(){
        var client = new ClientHttpConfiguration();
        var abrigoService = new AbrigoService(client);
        var petService = new PetService(client);
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
                    case 1:
                        abrigoService.listarAbrigosCadastrados();
                        break;
                    case 2:
                        abrigoService.cadastrarNovoAbrigo();
                        break;
                    case 3:
                        petService.listarPetsDoAbrigo();
                        break;
                    case 4:
                        petService.importarPetsDoAbrigo();
                        break;
                    case 5:
                        System.out.println("Finalizando programa...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

