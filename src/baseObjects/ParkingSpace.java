package baseObjects;

import cars.Car;
import cars.Truck;

import java.util.LinkedList;

public class ParkingSpace {

    private final LinkedList<Car> parkingQueue;
    private Integer parkingSize;

    public ParkingSpace() {
        parkingQueue = new LinkedList<>();
        parkingSize = 0;
    }

    public void addCarToParkingSpace(Car car) {
        if (car instanceof Truck) {
            // приехал грузовик
            parkingQueue.offerLast(car);
        } else {
            // приехал камаз
            parkingQueue.offerFirst(car);
        }
        parkingSize++;
    }

    public Car removeCarFromParkingSpace() {
        parkingSize--;
        return parkingQueue.pollFirst();
    }

    public Integer getParkingSize() {
        return parkingSize;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "parkingQueue=" + parkingQueue +
                ", parkingSize=" + parkingSize +
                '}';
    }
}
