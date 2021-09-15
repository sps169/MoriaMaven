public class Ring extends Items{
    private boolean isWeared;

    public Ring(String name) {
        super(name);
        this.isWeared = false;
    }

    public boolean isWeared() {
        return isWeared;
    }

    public void setWeared(boolean weared) {
        isWeared = weared;
    }

    public void putOnRing() {
        this.isWeared = true;
    }

    public void takeOffRing() {
        this.isWeared = false;
    }
}
