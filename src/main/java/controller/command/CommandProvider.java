package controller.command;

import controller.command.impl.*;
import controller.command.impl.coffee.AddCoffeeCommand;
import controller.command.impl.coffee.DeleteCoffeeCommand;
import controller.command.impl.coffee_machine.AddCoffeeMachineCommand;
import controller.command.impl.coffee_machine.DeleteCoffeeMachineCommand;
import controller.command.impl.go_to.GoToErrorPageCommand;
import controller.command.impl.go_to.GoToMainPageCommand;
import controller.command.impl.order.TakeOrderCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<ParameterName, Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put(ParameterName.REGISTRATION, new RegistrationCommand());
        commands.put(ParameterName.AUTHORIZATION, new AuthorizationCommand());
        commands.put(ParameterName.GO_TO_MAIN_PAGE, new GoToMainPageCommand());
        commands.put(ParameterName.ADD_COFFEE, new AddCoffeeCommand());
        commands.put(ParameterName.GO_TO_ERROR_PAGE, new GoToErrorPageCommand());
        commands.put(ParameterName.ADD_COFFEE_MACHINE, new AddCoffeeMachineCommand());
        commands.put(ParameterName.DELETE_COFFEE, new DeleteCoffeeCommand());
        commands.put(ParameterName.DELETE_COFFEE_MACHINE, new DeleteCoffeeMachineCommand());
        commands.put(ParameterName.TAKE_ORDER, new TakeOrderCommand());
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
