package task.enums;

public enum CommandType {
    COMMAND("command"),
    ERROR("error"),
    FILE("file");

    private String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
