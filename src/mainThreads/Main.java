package mainThreads;

import cars.Truck;
import towns.Town;
import warehouses.Warehouse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Создание формата отображения даты
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        //Вывод нынешней даты и времени
        System.out.println("\nДата: " + new Date().toString());
        Town Ekaterinburg = new Town(7, RandomNumberInRange(10, 30), 1.0/1);
        Town NizhnyTagil = new Town(5, RandomNumberInRange(130, 140), 1.0/2);
        Town KamenskUralsky = new Town(4, RandomNumberInRange(125, 135), 1.0/3);
        Town SatelliteTownsYekaterinburg = new Town(4, RandomNumberInRange(10, 30), 1.0/4);
        while (true) {
            
        }
    }

    private static Integer RandomNumberInRange(Integer min, Integer max) {
        return (int)(Math.random()*((max-min)+1))+min;
    }
}
