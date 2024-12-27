package br.com.LeoChiarelli.adopet.service;

import br.com.LeoChiarelli.adopet.client.ClientHttpConfiguration;
import br.com.LeoChiarelli.adopet.domain.Abrigo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AbrigoService {
    protected Scanner scanner = new Scanner(System.in);
    protected ClientHttpConfiguration client;
    protected String url = "http://localhost:8080/abrigos/";

    public AbrigoService(ClientHttpConfiguration client) {
        this.client = client;
    }

    public void listarAbrigosCadastrados() throws IOException, InterruptedException {
        HttpResponse<String> response = client.dispararRequisicaoGet(url);
        String responseBody = response.body();

        Abrigo[] abrigos = new Gson().fromJson(responseBody, Abrigo[].class);
        List<Abrigo> abrigoList = Arrays.stream(abrigos).toList();

        if(abrigoList.isEmpty()){
            System.out.println("Não há abrigos cadastrados.");
        } else {
            mostrarAbrigos(abrigoList);
        }
    }

    public void mostrarAbrigos(List<Abrigo> abrigos){
        System.out.println("Abrigos cadastrados:");
        for (Abrigo abrigo : abrigos) {
            long id = abrigo.getId();
            String nome = abrigo.getNome();
            System.out.println(id + " - " + nome);
        }
    }

    public void cadastrarNovoAbrigo() throws IOException, InterruptedException {
        System.out.println("Digite o nome do abrigo:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do abrigo:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o email do abrigo:");
        String email = scanner.nextLine();

        var abrigo = new Abrigo(nome, telefone, email);


        HttpResponse<String> response = client.dispararRequisicaoPost(url, abrigo);

        int statusCode = response.statusCode();
        String responseBody = response.body();
        if (statusCode == 200) {
            System.out.println("Abrigo cadastrado com sucesso!");
            System.out.println(responseBody);
        } else if (statusCode == 400 || statusCode == 500) {
            System.out.println("Erro ao cadastrar o abrigo:");
            System.out.println(responseBody);
        }
    }
}
