package fields;

import undefined.Colors;

public abstract class Field {
    public String name;
    public boolean specialField;

    public Field(String name, boolean specialField) {
        this.name = name;
        this.specialField = specialField;
    }

    public String getName() {
        return name;
    }
    public boolean isSpecialField() {
        return specialField;
    }
}

