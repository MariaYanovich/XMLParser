package by.epam.training.task.command.impl;

import by.epam.training.task.builder.AbstractToursBuilder;
import by.epam.training.task.builder.dom.ToursDOMBuilder;
import by.epam.training.task.command.Command;
import by.epam.training.task.service.ServiceParser;
import by.epam.training.task.entity.Tours;
import by.epam.training.task.enums.PageType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DOMCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        AbstractToursBuilder builder = new ToursDOMBuilder();
        Tours tours = ServiceParser.INSTANCE.parseXML(request, builder);
        request.setAttribute("tours", tours.getTours());
        return PageType.TABLE_PAGE.getValue();

    }
}
