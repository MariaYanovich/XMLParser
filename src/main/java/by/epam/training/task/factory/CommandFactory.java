package by.epam.training.task.factory;

import by.epam.training.task.command.Command;
import by.epam.training.task.command.impl.DOMCommand;
import by.epam.training.task.command.impl.ErrorCommand;
import by.epam.training.task.command.impl.SAXCommand;
import by.epam.training.task.command.impl.STAXCommand;
import by.epam.training.task.enums.ParserType;

public class CommandFactory {

    private CommandFactory() {

    }

    public static CommandFactory getInstance() {
        return CommandHolder.COMMAND_HOLDER_INSTANCE;
    }

    public Command doCommand(String typeParser) {
        ParserType type = ParserType.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DOMCommand();
            case STAX:
                return new STAXCommand();
            case SAX:
                return new SAXCommand();
            default:
                return new ErrorCommand();
        }
    }

    private static class CommandHolder {
        public static final CommandFactory COMMAND_HOLDER_INSTANCE = new CommandFactory();
    }
}
