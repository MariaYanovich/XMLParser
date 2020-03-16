package by.epam.training.task.command.impl;

import by.epam.training.task.command.Command;
import by.epam.training.task.enums.PageType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageType.ERROR_PAGE.getValue();
    }
}
