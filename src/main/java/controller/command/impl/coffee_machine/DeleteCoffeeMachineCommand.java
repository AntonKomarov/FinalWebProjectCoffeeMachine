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

public class DeleteCoffeeMachineCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=go_to_main_page";
    private static final String ERROR_PAGE = "controller?command=go_to_error_page";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean isDeleted;
        String page;

        coffeeMachine.setModel(request.getParameter("model"));
        System.out.println(coffeeMachine.getModel());

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        CoffeeMachineService coffeeMachineService = serviceProvider.getCoffeeMachineService();

        try{
            isDeleted = coffeeMachineService.deleteCoffeeMachineByModel(coffeeMachine);
            if (isDeleted){
                page = MAIN_PAGE;
            } else {
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
