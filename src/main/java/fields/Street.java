package fields;

import undefined.Colors;

public class Street extends Field {
    private int price;
    private Colors color;

    public Street(String name, int price, Colors color, boolean specialField) {
        super(name,specialField);
        this.price = price;
        this.color = color;
    }


}
