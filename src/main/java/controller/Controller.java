package controller;

import controller.command.Command;
import controller.command.CommandProvider;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String COMMAND_NAME = "command";
    private final CommandProvider commandProvider = new CommandProvider();

    public Controller(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("GET");
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("POST");
        process(request, response);
//        request.getSession(true).setAttribute("local", request.getParameter("local"));
//        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DELETE");
        process(req,resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String commandName = request.getParameter(COMMAND_NAME);
        Command command = commandProvider.getCommand(commandName);
        command.execute(request, response);
    }
}
