package br.com.LeoChiarelli.adopet;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

@SpringBootApplication
public class AdopetApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdopetApplication.class, args);
	}

	protected static Scanner scanner = new Scanner(System.in);
	protected static final String URL = "http://localhost:8080/abrigos/";
	protected static final HttpClient CLIENT = HttpClient.newHttpClient();
	protected static final JsonObject JSON = new JsonObject();

	@Override
	public void run(String... args) throws Exception {
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
						listarAbrigosCadastrados();
						break;
					case 2:
						cadastrarNovoAbrigo();
						break;
					case 3:
						listarPetsDoAbrigo();
						break;
					case 4:
						importarPetsDoAbrigo();
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

	private static void listarAbrigosCadastrados() throws IOException, InterruptedException {
		HttpResponse<String> response = dispararRequisicaoGet(CLIENT, URL);
		String responseBody = response.body();

		var jsonArray = JsonParser.parseString(responseBody).getAsJsonArray();
		System.out.println("Abrigos cadastrados:");
		for (JsonElement element : jsonArray) {
			JsonObject jsonObject = element.getAsJsonObject();
			long id = jsonObject.get("id").getAsLong();
			String nome = jsonObject.get("nome").getAsString();
			System.out.println(id + " - " + nome);
		}
	}

	private static void cadastrarNovoAbrigo() throws IOException, InterruptedException {
		System.out.println("Digite o nome do abrigo:");
		String nome = scanner.nextLine();
		System.out.println("Digite o telefone do abrigo:");
		String telefone = scanner.nextLine();
		System.out.println("Digite o email do abrigo:");
		String email = scanner.nextLine();

		JSON.addProperty("nome", nome);
		JSON.addProperty("telefone", telefone);
		JSON.addProperty("email", email);


		HttpResponse<String> response = dispararRequisicaoPost(CLIENT, URL, JSON);

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

	private static void listarPetsDoAbrigo() throws IOException, InterruptedException {
		System.out.println("Digite o id ou nome do abrigo:");
		String idOuNome = scanner.nextLine();

		String uri = URL + idOuNome + "/pets";
		HttpResponse<String> response = dispararRequisicaoGet(CLIENT, uri);

		int statusCode = response.statusCode();
		if (statusCode == 404 || statusCode == 500) {
			System.out.println("ID ou nome não cadastrado!");
		}
		String responseBody = response.body();
		JsonArray jsonArray = JsonParser.parseString(responseBody).getAsJsonArray();
		System.out.println("Pets cadastrados:");
		for (JsonElement element : jsonArray) {
			JsonObject jsonObject = element.getAsJsonObject();
			long id = jsonObject.get("id").getAsLong();
			String tipo = jsonObject.get("tipo").getAsString();
			String nome = jsonObject.get("nome").getAsString();
			String raca = jsonObject.get("raca").getAsString();
			int idade = jsonObject.get("idade").getAsInt();
			System.out.println(id + " - " + tipo + " - " + nome + " - " + raca + " - " + idade + " ano(s)");
		}
	}

	private static void importarPetsDoAbrigo() throws IOException, InterruptedException {
		System.out.println("Digite o id ou nome do abrigo:");
		String idOuNome = scanner.nextLine();

		System.out.println("Digite o nome do arquivo CSV:");
		String nomeArquivo = scanner.nextLine();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(nomeArquivo));
		} catch (IOException e) {
			System.out.println("Erro ao carregar o arquivo: " + nomeArquivo);
		}
		String line;
		while ((line = reader.readLine()) != null) {
			String[] campos = line.split(",");
			String tipo = campos[0];
			String nome = campos[1];
			String raca = campos[2];
			int idade = Integer.parseInt(campos[3]);
			String cor = campos[4];
			Float peso = Float.parseFloat(campos[5]);


			JSON.addProperty("tipo", tipo.toUpperCase());
			JSON.addProperty("nome", nome);
			JSON.addProperty("raca", raca);
			JSON.addProperty("idade", idade);
			JSON.addProperty("cor", cor);
			JSON.addProperty("peso", peso);

			String uri = URL + idOuNome + "/pets";
			HttpResponse<String> response = dispararRequisicaoPost(CLIENT, uri, JSON);

			int statusCode = response.statusCode();
			String responseBody = response.body();
			if (statusCode == 200) {
				System.out.println("Pet cadastrado com sucesso: " + nome);
			} else if (statusCode == 404) {
				System.out.println("Id ou nome do abrigo não encontado!");
				break;
			} else if (statusCode == 400 || statusCode == 500) {
				System.out.println("Erro ao cadastrar o pet: " + nome);
				System.out.println(responseBody);
				break;
			}
		}
		reader.close();
	}

	private static HttpResponse<String> dispararRequisicaoGet(HttpClient client, String url) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		return client.send(request, HttpResponse.BodyHandlers.ofString());
	}

	private static HttpResponse<String> dispararRequisicaoPost(HttpClient client, String url, JsonObject json) throws IOException, InterruptedException{
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("Content-Type", "application/json")
				.method("POST", HttpRequest.BodyPublishers.ofString(json.toString()))
				.build();
		return client.send(request, HttpResponse.BodyHandlers.ofString());
	}
}


