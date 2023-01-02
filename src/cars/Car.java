package cars;

public abstract class Car {
    private TypeMachine typeMachine;
    private Integer speed;

    public Car(TypeMachine typeMachine, Integer speed) {
        this.typeMachine = typeMachine;
        this.speed = speed;
    }

    public TypeMachine getTypeMachine() {
        return typeMachine;
    }

    public void setTypeMachine(TypeMachine typeMachine) {
        this.typeMachine = typeMachine;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "typeMachine=" + typeMachine +
                ", speed=" + speed +
                '}';
    }
}
