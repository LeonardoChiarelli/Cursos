package br.com.LeoChiarelli.adopet.client;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttpConfiguration {

    protected final String URL = "http://localhost:8080/abrigos/";
    protected final HttpClient CLIENT = HttpClient.newHttpClient();

    public HttpResponse<String> dispararRequisicaoGet() throws
            IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> dispararRequisicaoGet(String uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> dispararRequisicaoPost(Object object) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(new Gson().toJson(object)))
                .build();
        return CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> dispararRequisicaoPost(String uri, Object object) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(new Gson().toJson(object)))
                .build();
        return CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
