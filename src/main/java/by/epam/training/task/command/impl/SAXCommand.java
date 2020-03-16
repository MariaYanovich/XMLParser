package by.epam.training.task.command.impl;

import by.epam.training.task.builder.sax.ToursSAXBuilder;
import by.epam.training.task.command.Command;
import by.epam.training.task.entity.Tours;
import by.epam.training.task.enums.PageType;
import by.epam.training.task.service.ServiceParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SAXCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Tours tours = ServiceParser.INSTANCE.parseXML(request, new ToursSAXBuilder());
        request.setAttribute("tours", tours.getTours());
        return PageType.TABLE_PAGE.getValue();
    }
}
