package model;

public abstract class Vehicle {
    private Double speed;
    private Double acceleration;
    private Double angleOfRotation;
    private String patent;
    private Double weight;
    private Integer wheels;

    public Vehicle(Double speed, Double acceleration, Double angleOfRotation, String patent, Double weight, Integer wheels) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.angleOfRotation = angleOfRotation;
        this.patent = patent;
        this.weight = weight;
        this.wheels = wheels;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Double acceleration) {
        this.acceleration = acceleration;
    }

    public Double getAngleOfRotation() {
        return angleOfRotation;
    }

    public void setAngleOfRotation(Double angleOfRotation) {
        this.angleOfRotation = angleOfRotation;
    }

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getWheels() {
        return wheels;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return " speed=" + speed +
                ", acceleration=" + acceleration +
                ", angleOfRotation=" + angleOfRotation +
                ", patent='" + patent + '\'' +
                ", weight=" + weight +
                ", wheels=" + wheels;
    }
}
