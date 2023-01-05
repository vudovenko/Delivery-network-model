package mainThreads;

import baseObjects.Base;
import baseObjects.CarPark;
import baseObjects.Warehouse;
import towns.Town;
import towns.TypeProduct;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        startProgram();
    }

    private static void startProgram() {
        TimeClass timeClass = new TimeClass();
        Town Ekaterinburg = new Town(7, randomNumberInRange(10, 30),
                1, "Екатеринбург");
        Town NizhnyTagil = new Town(5, randomNumberInRange(130, 140),
                2, "Нижний Тагил");
        Town KamenskUralsky = new Town(4, randomNumberInRange(125, 135),
                3, "Каменск-Уральский");
        Town SatelliteTownsYekaterinburg = new Town(4, randomNumberInRange(10, 30),
                4, "спутнике Екатеринбурга");
        Warehouse warehouse1 = new Warehouse("Склад1", TypeProduct.HEAVY_OVERSIZE);
        Warehouse warehouse2 = new Warehouse("Склад2", TypeProduct.HEAVY_OVERSIZE);
        Warehouse warehouse3 = new Warehouse("Склад3", TypeProduct.HEAVY_EURO_PALLETS);
        Warehouse warehouse4 = new Warehouse("Склад4", TypeProduct.PLUMBING);
        Warehouse warehouse5 = new Warehouse("Склад5", TypeProduct.LIGHT_EURO_PALLETS);

        ArrayList<Warehouse> warehouses = new ArrayList<>();
        warehouses.add(warehouse1);
        warehouses.add(warehouse2);
        warehouses.add(warehouse3);
        warehouses.add(warehouse4);
        warehouses.add(warehouse5);

        Base base = new Base(warehouses);
        CarPark carPark = new CarPark();

        timeClass.start();
        warehouse1.start();
        warehouse2.start();
        warehouse3.start();
        warehouse4.start();
        warehouse5.start();

        Base.sendKamazToWarehouses();
        Ekaterinburg.start();
        NizhnyTagil.start();
        KamenskUralsky.start();
        SatelliteTownsYekaterinburg.start();
    }

    public static Integer randomNumberInRange(Integer min, Integer max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
