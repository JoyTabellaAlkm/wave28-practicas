package Entities;

import java.util.List;

public class Receipt {

    // ATTRIBUTES
    private int receiptId;
    private Client client;
    private List<Item> items;
    private double totalCost;

    // CONSTRUCTORS
    public Receipt(int receiptId, Client client, List<Item> items) {
        this.receiptId = receiptId;
        this.client = client;
        this.items = items;
        this.totalCost = items.stream()
                .mapToDouble(x -> x.getUnitCost() * x.getQuantity())
                .sum();
        ;
    }

    public Receipt(){

    }

    // GETS & SETS
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    // TO STRING


    @Override
    public String toString() {
        return "[Receipt] " +
                "\n Receipt Id: " + receiptId +
                "\n Client: " + client +
                "\n Items: " + items +
                "\n Total Cost: " + totalCost
                + "\n \n";
    }
}
