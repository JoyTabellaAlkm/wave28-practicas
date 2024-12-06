package model;

public class Car extends Vehicle{
    public Car(Double speed, Double acceleration, Double angleOfRotation, String patent) {
        super(speed, acceleration, angleOfRotation, patent, 1000.0, 4);
    }

    @Override
    public String toString() {
        return "Car: " + super.toString();
    }
}
