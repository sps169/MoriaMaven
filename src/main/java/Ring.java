public class Ring extends Item {
    private boolean isWearing;

    public Ring(String name) {
        super(name);
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
        return "Name: " + this.getName() + " ,Status: " + this.isWearing;
    }
}
