package task.factory;

import task.command.Command;
import task.command.impl.DOMCommand;
import task.command.impl.SAXCommand;
import task.command.impl.STAXCommand;

public class CommandFactory {

    private CommandFactory() {

    }

    public static CommandFactory getInstance() {
        return CommandHolder.HOLDER_INSTANCE;
    }

    public Command doCommand(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DOMCommand();
            case STAX:
                return new STAXCommand();
            case SAX:
                return new SAXCommand();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }

    private enum TypeParser {
        SAX, STAX, DOM
    }

    private static class CommandHolder {
        public static final CommandFactory HOLDER_INSTANCE = new CommandFactory();
    }
}
