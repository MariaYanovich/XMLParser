package by.epam.training.task.enums;

public enum TourEnum {
    TOURS("tours"),
    TOUR("tour"),
    ID("id"),
    TOURNAME("tourName"),
    TOURTYPE("tourType"),
    COUNTRY("country"),
    STARTDATE("startDate"),
    DAYS("days"),
    TRANSPORT("transport"),
    HOTELCHARACTERISTIC("hotelCharacteristic"),
    STARS("stars"),
    HOTELTYPE("hotelType"),
    ROOMS("rooms"),
    COST("cost");

    private String value;

    TourEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
