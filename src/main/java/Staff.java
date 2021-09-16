public class Staff extends Item {
private int energy;
private int maxEnergy;

    public Staff(String name, int energy, int maxEnergy) {
        super(name);
        this.energy = energy;
        this.maxEnergy = maxEnergy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int rechargeStaff(int newEnergy){
        if ((this.energy + newEnergy)>=this.maxEnergy){
            this.energy = this.maxEnergy;
        }
        else {
            this.energy += newEnergy;
        }
        return this.energy;
    }

    public String toString()
    {
        return "Name: " + this.getName() + ", CurrentEnergy: " + this.energy + ", MaxEnergy: " + this.maxEnergy;
    }
}
