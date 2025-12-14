package br.com.LeoChiarelli.screenMatch.modeloAPI.main;

import br.com.LeoChiarelli.screenMatch.modeloAPI.exceptions.ErroDeConversaoException;
import br.com.LeoChiarelli.screenMatch.modeloAPI.models.Title;
import br.com.LeoChiarelli.screenMatch.modeloAPI.models.TitleOMBD;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) throws IOException, InterruptedException { // Metodo para lidar com as 'exceptions'
        Scanner leitor = new Scanner(System.in);
        String busca = "";
        List<Title> lista = new ArrayList<>();
        // GSON
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create(); // Criando uma política de nomenclatura para a variável

        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Informe o filme que você gostaria de saber mais sobre:");
            busca = leitor.nextLine();

            if(busca.equalsIgnoreCase("Sair")){
                break;
            }

            // Try/Catch/Finally
            try {
                String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=7c66c456"; // Uma forma de adaptar o erro

                // Requisição
                HttpClient client = HttpClient.newBuilder().build();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

                // Resposta
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body(); // Atribuindo o corpo da resposta a uma variável
                System.out.println(json); // imprimindo o corpo da resposta do JSON

                // client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println).join(); // outra forma

                // Deserialization
                TitleOMBD meuTituloOmbd = gson.fromJson(json, TitleOMBD.class); // Transformando a resposta do json em um 'Record' TitleOMDB // Data Transfer Objects
                // System.out.println(meuTituloOmbd);
                Title meuTitulo = new Title(meuTituloOmbd); // Tentar formar um novo título
                System.out.println(meuTitulo);

                lista.add(meuTitulo);

            } catch (NumberFormatException e) { // Pega o erro e atribui uma variável ao erro
                System.out.println("[Erro]: " + e.getMessage()); // Melhor forma de mostrar um erro ao usuário

            } catch (IllegalArgumentException e) { // Pegar os erros que vão aparecendo
                System.out.println("[Erro]: " + e.getMessage());

            } catch (ErroDeConversaoException e) {
                System.out.println("[Erro]: " + e.getMessage());
            }
        }
        // System.out.println(lista);
        FileWriter escrita = new FileWriter("Filmes.json");
        escrita.write(gson.toJson(lista));
        escrita.close();
        System.out.println("Programa finalizado");
    }
}

// Design Pattern - Padrão de projeto

/*
    "File > Project Structure" (ou use atalho "Ctrl + Alt + Shift + S") para visualizar a estrutura do projeto.

    Na janela "Project Structure", vamos clicar na opção "Modules" e depois a aba "Dependencies" (dependências), onde podemos indicar do que o nosso projeto depende e incluir um arquivo.

    Para isso, podemos clicar no botão "Add" que possui um símbolo de "+" (ou use atalho "Alt + Insert") que nos dá opções para adicionar um JAR, biblioteca ou módulo. No nosso caso, vamos selecionar "JARs or Directories", pois já fizemos o download do JAR.

    Vamos escolher o arquivo baixado gson-2.10.1.jar que já colocamos dentro de uma pasta chamada "dependência". Após incluir a dependência, podemos clicar no botão "OK" no canto inferior direito.

    A partir desse momento, já podemos digitar "Gson" no código que vai aparecer a sugestão da classe Gson.
 */

// Stack trace - rastro da pilha de excução (mensagens de erro)
// Os erros são analisados de baixo para cima
// Exception - classe-mãe das exceções
// Exceções podem ser previstas, tratadas e antecipadas
// Ctrl + Alt + i - indentação