package by.epam.training.task.controller;

import by.epam.training.task.command.Command;
import by.epam.training.task.enums.CommandType;
import by.epam.training.task.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/table")
@MultipartConfig
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Command command = CommandFactory.getInstance().doCommand(request.getParameter(CommandType.COMMAND.getValue()));
        String nextPage = command.execute(request, response);
        request.getRequestDispatcher(nextPage).forward(request, response);
    }
}
