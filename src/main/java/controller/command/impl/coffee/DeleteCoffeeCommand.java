package controller.command.impl.coffee;

import controller.command.Command;
import entity.Coffee;
import service.CoffeeService;
import service.exception.ServiceException;
import service.provider.ServiceProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCoffeeCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=go_to_main_page";
    private static final String ERROR_PAGE = "controller?command=go_to_error_page";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isDelete = false;
        Coffee coffee = new Coffee();
        String page;

        coffee.setName(request.getParameter("name"));

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        CoffeeService coffeeService = serviceProvider.getCoffeeService();

        try{
            isDelete = coffeeService.deleteCoffee(coffee);
            if (isDelete){
                page = MAIN_PAGE;
            } else {
                request.setAttribute("error", "try to delete again");
                page = ERROR_PAGE;
            }
        } catch (ServiceException e) {
            request.setAttribute("error", "false");
            page = ERROR_PAGE;
        }

        response.sendRedirect(page);
    }
}
