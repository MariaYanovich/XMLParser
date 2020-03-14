package task.command.impl;

import task.builder.AbstractToursBuilder;
import task.builder.dom.ToursDOMBuilder;
import task.command.Command;
import task.service.ServiceParser;
import task.entity.Tours;
import task.enums.PageType;

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
