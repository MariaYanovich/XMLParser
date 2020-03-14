package task.service;

import org.apache.log4j.Logger;
import task.builder.AbstractToursBuilder;
import task.entity.Tours;
import task.enums.CommandType;
import task.validator.Validator;

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
            Part filePart = request.getPart(CommandType.FILE.getValue());
            InputStream fileContent = filePart.getInputStream();
            if (Validator.isValidResources()) {
                builder.buildTours(fileContent);
            }
        } catch (IOException | ServletException e) {
            LOGGER.error(e);
        }
        return builder.getTours();
    }
}
