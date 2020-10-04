package controller.impl;

import controller.command.Command;
import entity.Registration;
import service.UserService;
import service.exception.ServiceException;
import service.provider.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {
    private static final String PARAMETER_LOGIN = "login";
    private static final String PARAMETER_PASSWORD = "password";
    private static final String PARAMETER_EMAIL = "email";
    private static final String PARAMETER_PHONE = "phone";
//    private static final String PARAMETER_NAME = "name";
//    private static final String PARAMETER_SURNAME = "surname";

    private static final String MAIN_PAGE = "controller?command=go_to_main_page";
    private static final String INDEX_PAGE = "index.jsp";
    private static final String REGISTRATION_PAGE = "WEB-INF/jsp/registration.jsp";
    private static final String USER_PAGE = "WEB-INF/jsp/userPage.jsp";
    private static final String DEFAULT_PAGE = "/WEB-INF/jsp/default.jsp";



    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("We are in the RegistrationCommand page");

        String login;
        String password;
        String email;
        String phone;
//        String name;
//        String surname;

        login = request.getParameter(PARAMETER_LOGIN);
        password = request.getParameter(PARAMETER_PASSWORD);
        phone = request.getParameter(PARAMETER_PHONE);
        email = request.getParameter(PARAMETER_EMAIL);
//        name = request.getParameter(PARAMETER_NAME);
//        surname = request.getParameter(PARAMETER_SURNAME);

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        Registration registration = new Registration();
        boolean result = false;
        String page;

        registration.setLogin(login);
        registration.setPassword(password);
        registration.setPhone(phone);
        registration.setEmail(email);
//        registration.setName(name);
//        registration.setSurname(surname);

        System.out.println("registration success");

        try{
            result = userService.registration(registration);
            if (result){
                page = MAIN_PAGE;
                System.out.println("go to main page");
            } else {
                request.setAttribute("error", "false false false");
                page = DEFAULT_PAGE;
            }
        } catch (ServiceException exception){
            request.setAttribute("error", "Error. Try again!");
            page = DEFAULT_PAGE;
        }


//        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
//        requestDispatcher.forward(request, response);
        response.sendRedirect(page);
    }
}