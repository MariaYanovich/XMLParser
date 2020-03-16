package by.epam.training.task.command.impl;

import by.epam.training.task.builder.stax.ToursStAXBuilder;
import by.epam.training.task.command.Command;
import by.epam.training.task.entity.Tours;
import by.epam.training.task.enums.PageType;
import by.epam.training.task.service.ServiceParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class STAXCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Tours tours = ServiceParser.INSTANCE.parseXML(request, new ToursStAXBuilder());
        if (tours.getTours().isEmpty()) {
            return PageType.ERROR_PAGE.getValue();
        }
        request.setAttribute("tours", tours.getTours());
        return PageType.RESULT_TABLE_PAGE.getValue();
    }
}