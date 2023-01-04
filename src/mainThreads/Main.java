package mainThreads;

import towns.Town;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Вывод нынешней даты и времени
        System.out.println("\nДата: " + new Date());
        Town Ekaterinburg = new Town(7, randomNumberInRange(10, 30),
                1, "Екатерибург");
        Town NizhnyTagil = new Town(5, randomNumberInRange(130, 140),
                2, "Нижний Тагил");
        Town KamenskUralsky = new Town(4, randomNumberInRange(125, 135),
                3, "Каменск-Уральский");
        Town SatelliteTownsYekaterinburg = new Town(4, randomNumberInRange(10, 30),
                4, "спуника Екатеринбурга");
        while (true) {
            Ekaterinburg.start();
            NizhnyTagil.start();
            KamenskUralsky.start();
            SatelliteTownsYekaterinburg.start();
        }
    }

    public static Integer randomNumberInRange(Integer min, Integer max) {
        return (int)(Math.random()*((max-min)+1))+min;
    }
}
