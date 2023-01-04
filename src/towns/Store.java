package towns;

import interfaces.DemonstratingStatus;
import mainThreads.Main;

public class Store implements DemonstratingStatus {
    private Town town;
    private Integer id;
    private Boolean isDemandSatisfied;
    private TypeProduct thisProductNeed;

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

    public Boolean getIsDemandSatisfied() {
        return isDemandSatisfied;
    }

    public void setIsDemandSatisfied(Boolean demandSatisfied) {
        isDemandSatisfied = demandSatisfied;
    }

    public TypeProduct getThisProductNeed() {
        return thisProductNeed;
    }

    public void setThisProductNeed(TypeProduct thisProductNeed) {
        this.thisProductNeed = thisProductNeed;
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
            thisProductNeed = generateRandomTypeProduct();
            System.out.println("В городе " + town.getTownName() + " магазин №" + id +
                    " нуждается в товаре " + thisProductNeed.getName());
        }
    }

    private TypeProduct generateRandomTypeProduct() {
        int randomNumber = Main.randomNumberInRange(1, 4);
        if (randomNumber == 1) {
            return TypeProduct.HEAVY_OVERSIZE;
        } else if (randomNumber == 2) {
            return TypeProduct.HEAVY_EURO_PALLETS;
        } else if (randomNumber == 3) {
            return TypeProduct.PLUMBING;
        } else {
            return TypeProduct.LIGHT_EURO_PALLETS;
        }
    }
}
