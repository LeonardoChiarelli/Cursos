package br.com.LeoChiarelli.screenSoundSpring.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ChatgptQuery {

    public static String getInfo(String texto){
        OpenAiService service = new OpenAiService(System.getenv("OPENAI_KEY"));

        CompletionRequest request = CompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .prompt("Me fale sobre o artista: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var response = service.createCompletion(request);
        return response.getChoices().getFirst().getText();
    }
}
