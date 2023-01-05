package towns;

import baseObjects.CarPark;
import cars.Truck;
import interfaces.DemonstratingStatus;
import mainThreads.Main;
import mainThreads.TimeClass;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

    public static void getTruckWithProduct(Truck truck) {
        new Thread(() -> {
            try {
                Thread.sleep(Store.calculateTravelTime(truck) * TimeClass.VIRTUAL_HOUR);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("В магазин №" + truck.getStore().getId()
                    + " города " + truck.getStore().getTown().getTownName() + " прибыл грузовик с товаром "
                    + truck.getTypeProduct().getName());
            CarPark.sendCarToPark(truck);
            truck.getStore().setIsDemandSatisfied(true);
            truck.getStore().showStatus();
        }).start();
    }

    public static Integer calculateTravelTime(Truck truck) {
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(TimeClass.getCurrentDate());   // assigns calendar to given date
        Integer hours = calendar.get(Calendar.HOUR_OF_DAY);
        if (hours >=12) {
            return truck.getTown().getDistanceToBase() / truck.getDaySpeed();
        } else {
            return truck.getTown().getDistanceToBase() / truck.getNightSpeed();
        }
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
            System.out.println("Спрос магазина №" + getId()
                    + " в городе " + getTown().getTownName()
                    + " по товару " + getThisProductNeed().getName()
                    + " удовлетворен");
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
