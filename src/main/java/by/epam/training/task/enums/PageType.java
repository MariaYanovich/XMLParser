package by.epam.training.task.enums;

public enum PageType {
    DEFAULT_PAGE("index.jsp"),
    ERROR_PAGE("/view/error.jsp"),
    RESULT_TABLE_PAGE("/view/table.jsp");

    private String value;

    PageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
