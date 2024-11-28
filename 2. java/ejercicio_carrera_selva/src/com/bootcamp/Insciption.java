package com.bootcamp;

public class Insciption {
    private int nroInscription;
    private Category category;
    private Competitor competitor;
    private double price;


    public Insciption(int nroInscription, Category category, Competitor competitor) {
        this.nroInscription = nroInscription;
        this.category = category;
        this.competitor = competitor;
        calculatePrice();
    }

    @Override
    public String toString() {
        return "Insciption{" +"\n"+
                " nroInscription=" + nroInscription +",\n"+
                " category=" + category.toString() +",\n"+
                " competitor=" + competitor.toString() +",\n"+
                " price=" + price +"\n"+
                '}';
    }

    private void calculatePrice() {
        int age = competitor.getAge();
        switch (category.getName()) {
            case "Circuito chico":
                this.price = age < 18 ? 1300 : 1500;
                break;
            case "Circuito medio":
                this.price = age < 18 ? 2000 : 2300;
                break;
            case "Circuito avanzado":
                this.price = age < 18 ? 0 : 2800;
                break;
            default:
                this.price = 0;
        }
    }

    public String getCategoryName(){
        return category.getName();
    }

    public double getPrice() {
        return price;
    }
}
