package controller.command.impl.coffee_machine;

import controller.command.Command;
import entity.CoffeeMachine;
import service.CoffeeMachineService;
import service.exception.ServiceException;
import service.provider.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCoffeeMachineCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=go_to_main_page";
    private static final String ERROR_PAGE = "controller?command=go_to_error_page";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean isAdded = false;
        String page;

        coffeeMachine.setIdUser(Integer.parseInt(request.getParameter("idUser")));
        coffeeMachine.setModel(request.getParameter("model"));

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        CoffeeMachineService coffeeMachineService = serviceProvider.getCoffeeMachineService();

        try{
             isAdded = coffeeMachineService.addCoffeeMachine(coffeeMachine);
             if (isAdded){
                 page = MAIN_PAGE;
             } else{
                 request.setAttribute("error", "try again");
                 page = ERROR_PAGE;
             }
        } catch (ServiceException e) {
            request.setAttribute("error", "false");
            page = ERROR_PAGE;
        }

        response.sendRedirect(page);
    }
}
