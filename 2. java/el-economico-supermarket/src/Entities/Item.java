package Entities;

public class Item {
    // ATTRIBUTES
    private int codeId;
    private String name;
    private int quantity;
    private double unitCost;

    // CONSTRUCTOR
    public Item(int codeId, String name, int quantity, double unitCost) {
        this.codeId = codeId;
        this.name = name;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public Item(){

    }

    // GETS & SETS
    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    // TO STRING


    @Override
    public String toString() {
        return "[Item] " +
                "Code Id: " + codeId +
                "\n Name: " + name +
                "\n Quantity: " + quantity +
                "\n Unit Cost: " + unitCost +
                "\n \n";
    }
}
