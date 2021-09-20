package Items;

import Dangers.DangerType;

public class Ring extends Item {
    private boolean isWearing;
    private final static DangerType ringDangerType = DangerType.ability;

    public Ring(String name) {
        super(name, ringDangerType);
        this.isWearing = false;
    }

    public boolean getIsWearing() {
        return isWearing;
    }

    public void setIsWearing(boolean isWearing) {
        isWearing = isWearing;
    }

    public void putOnRing() {
        this.isWearing = true;
    }

    public void takeOffRing() {
        this.isWearing = false;
    }

    @Override
    public String toString()
    {
        return "Name: " + this.getName() + " ,Status: " + this.isWearing
                + ", Dangers.Danger Type: " + this.getDangerType();
    }
}
