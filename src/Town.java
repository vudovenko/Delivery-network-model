public class Town {
    private int numberStores;
    private int distanceToBase;
    private int demand;
    private boolean isDemandSatisfied;

    public Town(int numberStores, int distanceToBase, int demand, boolean isDemandSatisfied) {
        this.numberStores = numberStores;
        this.distanceToBase = distanceToBase;
        this.demand = demand;
        this.isDemandSatisfied = isDemandSatisfied;
    }

    public int getNumberStores() {
        return numberStores;
    }

    public int getDistanceToBase() {
        return distanceToBase;
    }

    public int getDemand() {
        return demand;
    }

    public boolean isDemandSatisfied() {
        return isDemandSatisfied;
    }

    public void setNumberStores(int numberStores) {
        this.numberStores = numberStores;
    }

    public void setDistanceToBase(int distanceToBase) {
        this.distanceToBase = distanceToBase;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public void setDemandSatisfied(boolean demandSatisfied) {
        isDemandSatisfied = demandSatisfied;
    }

    @Override
    public String toString() {
        return "Town{" +
                "numberStores=" + numberStores +
                ", distanceToBase=" + distanceToBase +
                ", demand=" + demand +
                ", isDemandSatisfied=" + isDemandSatisfied +
                '}';
    }
}
