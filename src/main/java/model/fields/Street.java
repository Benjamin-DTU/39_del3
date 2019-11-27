package model.fields;

import model.undefined.Colors;
import model.undefined.Player;

public class Street extends Field {
    private int price;
    private Colors color;
    private Player owner;
    private boolean bothOwned;

    public Street(String name, int price, Colors color, boolean specialField) {
        super(name,specialField);
        this.price = price;
        this.color = color;
        this.owner = null;
        this.bothOwned = false;
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

    public boolean isBothOwned() {
        return bothOwned;
    }

    public void setBothOwned(boolean bothOwned) {
        this.bothOwned = bothOwned;
    }

}
