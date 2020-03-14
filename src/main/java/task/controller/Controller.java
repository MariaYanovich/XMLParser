package task.controller;

import task.command.Command;
import task.enums.CommandType;
import task.factory.CommandFactory;

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
        String name = request.getParameter(CommandType.COMMAND.getValue());
        Command command = CommandFactory.getInstance().doCommand(name);
        String forwardPage = command.execute(request, response);
        request.getRequestDispatcher(forwardPage).forward(request, response);
    }
}
