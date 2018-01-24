package hr.cobeisfresh.feelingit.data;

import java.util.Objects;

public class Feeling {

    private String name;
    private int type;

    public Feeling(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feeling feeling = (Feeling) o;
        return type == feeling.type &&
                Objects.equals(name, feeling.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, type);
    }
}
