public class Quiver extends Item {
    private int arrows;
    private int maxArrows;

    public Quiver(String name,int arrows, int maxArrows) {
        super(name);
        this.arrows = arrows;
        this.maxArrows = maxArrows;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public int getMaxArrows() {
        return maxArrows;
    }

    public void setMaxArrows(int maxArrows) {
        this.maxArrows = maxArrows;
    }

    public void shootArrow(){
        this.arrows--;
    }

    public void rechargeArrows(int newArrows){
        if ((this.arrows + newArrows)>=this.maxArrows){
            this.arrows = this.maxArrows;
        }
        else {
            this.arrows += newArrows;
        }
    }
}
