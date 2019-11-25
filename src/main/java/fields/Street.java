package fields;

import undefined.Colors;
import undefined.Player;

public class Street extends Field {
    private int price;
    private Colors color;
    private Player owner;

    public Street(String name, int price, Colors color, boolean specialField) {
        super(name,specialField);
        this.price = price;
        this.color = color;
        this.owner = null;
    }

    public int getPrice() {
        return price;
    }

    public Colors getColor() {
        return color;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
