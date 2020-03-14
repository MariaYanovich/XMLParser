package task.builder;

import task.entity.Tours;

import java.io.InputStream;

public abstract class AbstractToursBuilder {
    protected Tours tours;

    public AbstractToursBuilder() {
        tours = new Tours();
    }

    public Tours getTours() {
        return tours;
    }

    public abstract void buildTours(InputStream source);
}
