package br.com.LeoChiarelli.adopet.command;

import br.com.LeoChiarelli.adopet.client.ClientHttpConfiguration;
import br.com.LeoChiarelli.adopet.service.AbrigoService;

import java.io.IOException;

public class CadastrarNovoAbrigoCommand implements ICommand{
    @Override
    public void execute() {
        try {
            var client = new ClientHttpConfiguration();
            var service = new AbrigoService(client);

            service.cadastrarNovoAbrigo();
        } catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
