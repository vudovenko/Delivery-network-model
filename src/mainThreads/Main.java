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
        Town Ekaterinburg = new Town(7, randomNumberInRange(10, 30),
                1, "Екатерибург");
        Town NizhnyTagil = new Town(5, randomNumberInRange(130, 140),
                2, "Нижний Тагил");
        Town KamenskUralsky = new Town(4, randomNumberInRange(125, 135),
                3, "Каменск-Уральский");
        Town SatelliteTownsYekaterinburg = new Town(4, randomNumberInRange(10, 30),
                4, "спуника Екатеринбурга");
        while (true) {
            Ekaterinburg.generateRequest();
            NizhnyTagil.generateRequest();
            KamenskUralsky.generateRequest();
            SatelliteTownsYekaterinburg.generateRequest();
        }
    }

    public static Integer randomNumberInRange(Integer min, Integer max) {
        return (int)(Math.random()*((max-min)+1))+min;
    }
}
