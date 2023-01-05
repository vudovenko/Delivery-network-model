package cars;

public abstract class Car {
    private Integer nightSpeed;
    private Integer daySpeed;
    private Integer timeInWarehouse;

    public Car(Integer nightSpeed, Integer daySpeed, Integer timeInWarehouse) {
        this.nightSpeed = nightSpeed;
        this.daySpeed = daySpeed;
        this.timeInWarehouse = timeInWarehouse;
    }

    public Integer getTimeInWarehouse() {
        return timeInWarehouse;
    }

    public void setTimeInWarehouse(Integer timeInWarehouse) {
        this.timeInWarehouse = timeInWarehouse;
    }

    public Integer getNightSpeed() {
        return nightSpeed;
    }

    public void setNightSpeed(Integer nightSpeed) {
        this.nightSpeed = nightSpeed;
    }

    public Integer getDaySpeed() {
        return daySpeed;
    }

    public void setDaySpeed(Integer daySpeed) {
        this.daySpeed = daySpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nightSpeed=" + nightSpeed +
                ", daySpeed=" + daySpeed +
                ", timeInWarehouse=" + timeInWarehouse +
                '}';
    }
}
