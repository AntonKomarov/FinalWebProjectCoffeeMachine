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

public class AddCoffeeCommand implements Command{

    private static final String MAIN_PAGE = "controller?command=go_to_main_page";
    private static final String ERROR_PAGE = "controller?command=go_to_error_page";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Coffee coffee = new Coffee();
        boolean isAdded = false;
        String page;

        coffee.setName(request.getParameter("name"));
        coffee.setCost(request.getParameter("cost"));

        coffee.setCoffee_machines_idcoffee_machine(Integer.parseInt(request.getParameter("coffee_machines_idcoffee_machine")));

        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        CoffeeService coffeeService = serviceProvider.getCoffeeService();

        try{
            isAdded = coffeeService.addCoffee(coffee);
            if (isAdded){
                page = MAIN_PAGE;
            }
             else {
                 request.setAttribute("something is wrong", "try again");
                 page = ERROR_PAGE;
                System.out.println("error from add coffee command");
            }
        } catch (ServiceException e){
            request.setAttribute("ERROR!", "FALSE");
            page = ERROR_PAGE;
        }

        response.sendRedirect(page);
    }
}
