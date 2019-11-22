package fields;

import undefined.Colors;

public abstract class Field {
    public String name;
    public int price;
    public Colors color;
    public String fieldDescription;
    public boolean specialField;

    public Field(String name, int price, Colors color, String fieldDescription, boolean specialField) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.fieldDescription = fieldDescription;
        this.specialField = specialField;
    }

}

