package towns;

import interfaces.DemonstratingStatus;

public class Store implements DemonstratingStatus {
    private Town town;
    private Integer id;
    private Boolean isDemandSatisfied;

    public Store(Town town, Integer id) {
        this.town = town;
        this.id = id;
        this.isDemandSatisfied = true;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
            System.out.println("Магазин нуждается в товаре");
        }
    }
}
