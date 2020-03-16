package by.epam.training.task.service;

import by.epam.training.task.builder.AbstractToursBuilder;
import by.epam.training.task.entity.Tours;
import by.epam.training.task.enums.JSPParameterType;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public enum ServiceParser {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(ServiceParser.class);

    public Tours parseXML(HttpServletRequest request, AbstractToursBuilder builder) {
        try {
            Part filePart = request.getPart(JSPParameterType.FILE.getValue());
            InputStream fileContent = filePart.getInputStream();
            builder.buildTours(fileContent);
        } catch (IOException | ServletException e) {
            LOGGER.error(e);
        }
        return builder.getTours();
    }
}
