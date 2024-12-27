package br.com.LeoChiarelli.adopet.command;

public class CommandExecutor {

    public void executeCommand(ICommand command){
        command.execute();
    }

}
