package Items;

import Dangers.DangerType;

public abstract class Item {

private String name;
private DangerType dangerType;

    public Item(String name, DangerType dangerType) {
        this.name = name;
        this.dangerType = dangerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }

    public DangerType getDangerType() {
        return dangerType;
    }

    public void setDangerType(DangerType dangerType) {
        this.dangerType = dangerType;
    }
}
