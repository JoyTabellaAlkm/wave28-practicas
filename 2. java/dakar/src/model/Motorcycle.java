package model;

public class Motorcycle extends Vehicle{
    public Motorcycle(Double speed, Double acceleration, Double angleOfRotation, String patent) {
        super(speed, acceleration, angleOfRotation, patent, 300.0, 2);
    }

    @Override
    public String toString() {
        return "Motorcycle: " + super.toString();
    }
}
