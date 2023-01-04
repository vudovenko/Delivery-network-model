package baseObjects;

import cars.Car;

import java.util.LinkedList;

public class ParkingSpace {

    private final LinkedList<Car> parkingQueue;
    private Integer parkingSize;

    public ParkingSpace() {
        parkingQueue = new LinkedList<>();
        parkingSize = 0;
    }

    public void addCarToParkingSpace(Car car) {
        parkingQueue.offerLast(car);
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
