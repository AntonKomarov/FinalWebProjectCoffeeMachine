package controller.command;

import controller.impl.AuthorizationCommand;
import controller.impl.GoToMainPage;
import controller.impl.RegistrationCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<ParameterName, Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put(ParameterName.REGISTRATION, new RegistrationCommand());
        commands.put(ParameterName.AUTHORIZATION, new AuthorizationCommand());
        commands.put(ParameterName.GO_TO_MAIN_PAGE, new GoToMainPage());
    }

    public Command getCommand(String commandName){
        Command command;
        ParameterName valueName;

        commandName = commandName.toUpperCase();
        valueName = ParameterName.valueOf(commandName);

        command = commands.get(valueName);

        return command;
    }
}
