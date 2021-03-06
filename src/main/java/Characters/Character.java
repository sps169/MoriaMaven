package Characters;

import Items.Item;

public class Character {

    private String name;
    private String race;
    private boolean isLive;
    private Item item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString()
    {
        return "Name: " + this.name + ", Race: " + this.race + ", Status: "
                + this.isLive + ", Items.Item: (" + this.item.toString() + ")";
    }
}
