package towns;

import interfaces.DemonstratingStatus;

public class Store implements DemonstratingStatus {
    private Boolean isDemandSatisfied;

    public Store() {
        this.isDemandSatisfied = true;
    }

    public Store(Boolean isDemandSatisfied) {
        this.isDemandSatisfied = isDemandSatisfied;
    }

    public Boolean getDemandSatisfied() {
        return isDemandSatisfied;
    }

    public void setDemandSatisfied(Boolean demandSatisfied) {
        isDemandSatisfied = demandSatisfied;
    }

    @Override
    public String toString() {
        return "Store{" +
                "isDemandSatisfied=" + isDemandSatisfied +
                '}';
    }

    @Override
    public void showStatus() {
        if (isDemandSatisfied) {
            System.out.println("Спрос магазина удовлетворен");
        } else {
            System.out.println("Спрос магазина пока еще не удовлетворен");
        }
    }
}
