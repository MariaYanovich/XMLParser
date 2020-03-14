package task.enums;

public enum PageType {
    DEFAULT_PAGE("/index.jsp"),
    ERROR_PAGE("/error.jsp"),
    TABLE_PAGE("/table.jsp");

    private String value;

    PageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    }
