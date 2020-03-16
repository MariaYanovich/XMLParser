package by.epam.training.task.enums;

public enum JSPParameterType {
    COMMAND("command"),
    ERROR("error"),
    FILE("file");

    private String value;

    JSPParameterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
