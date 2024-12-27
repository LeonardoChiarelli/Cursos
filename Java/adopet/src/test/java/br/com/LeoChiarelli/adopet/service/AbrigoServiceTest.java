package br.com.LeoChiarelli.adopet.service;

import br.com.LeoChiarelli.adopet.client.ClientHttpConfiguration;
import br.com.LeoChiarelli.adopet.domain.Abrigo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AbrigoServiceTest {

    protected ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    protected AbrigoService service = new AbrigoService(client);
    protected HttpResponse<String> response = mock(HttpResponse.class);
    protected Abrigo abrigo = new Abrigo("Teste", "11974151557", "abrigo_Leo@gmail.com");

    @Test
    @DisplayName("Deve verficar quando há abrigo")
    void listarAbrigosCadastradosCenario1() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expectedAbrigoCadastrados = "Abrigos cadastrados:";
        String expectedIdENome = "0 - Teste";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[{" + abrigo.toString()+ "}]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);

        service.listarAbrigosCadastrados();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualAbrigosCadastrados = lines[0];
        String actualIdENome = lines[1];

        Assertions.assertEquals(expectedAbrigoCadastrados, actualAbrigosCadastrados);
        Assertions.assertEquals(expectedIdENome, actualIdENome);
    }

    @Test
    @DisplayName("Deve verficar quando não há abrigo")
    void listarAbrigosCadastradosCenario2() throws IOException, InterruptedException {
        abrigo.setId(0L);
        String expected = "Não há abrigos cadastrados.";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        when(response.body()).thenReturn("[]"); // Simulando retorno vazio
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);

        service.listarAbrigosCadastrados();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[0];

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void cadastrarNovoAbrigo() {
    }
}