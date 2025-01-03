package br.com.LeoChiarelli.adopet.command;

import br.com.LeoChiarelli.adopet.client.ClientHttpConfiguration;
import br.com.LeoChiarelli.adopet.service.PetService;

import java.io.IOException;

public class ImportarPetsDoAbrigoCommand implements ICommand{
    @Override
    public void execute() {
        try{
            var client = new ClientHttpConfiguration();
            var service = new PetService(client);

            service.importarPetsDoAbrigo();
        } catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
