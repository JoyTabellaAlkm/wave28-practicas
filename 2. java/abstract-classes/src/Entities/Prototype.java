package Entities;

public abstract class Prototype {
    // ATTRIBUTES
    private int startingValue;
    private int currentValue;
    private int jumpValue;


    // METHODS
    public int returnNextValue(){
        this.currentValue += jumpValue;
        return currentValue;
    }
    public void resetSeries(){
        this.currentValue = this.startingValue;
    }
    public void setStartingValue(int value){
        this.startingValue = value;
        this.currentValue = value;
    }

    // GETS & SETS

    public int getStartingValue() {
        return startingValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getJumpValue() {
        return jumpValue;
    }

    public void setJumpValue(int jumpValue) {
        this.jumpValue = jumpValue;
    }

    // CONSTRUCTOR

    public Prototype(int startingValue, int jumpValue) {
        this.startingValue = startingValue;
        this.currentValue = startingValue;
        this.jumpValue = jumpValue;
    }
}
