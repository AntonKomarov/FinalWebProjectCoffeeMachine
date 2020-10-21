package controller.command.impl;

import controller.command.Command;
import entity.Authorization;
import entity.User;
import service.UserService;
import service.exception.ServiceException;
import service.provider.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationCommand implements Command {
    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";

    private static final String MAIN_PAGE = "controller?command=go_to_main_page";
    private static final String DEFAULT_PAGE = "WEB-INF/jsp/default.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Authorization authorization = new Authorization();

        authorization.setLogin(request.getParameter(PARAMETER_LOGIN));
        authorization.setPassword(request.getParameter(PARAMETER_PASSWORD));

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        User user = null;
        String page;

        try{
            user = userService.authorization(authorization);

            if (user == null){
                request.setAttribute("error", "something is wrong");
                page = DEFAULT_PAGE;
            } else {
                request.setAttribute("user", user);
                page = MAIN_PAGE;
            }

        } catch(ServiceException exception){
            request.setAttribute("error", "login or password is wrong");
            page = DEFAULT_PAGE;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
