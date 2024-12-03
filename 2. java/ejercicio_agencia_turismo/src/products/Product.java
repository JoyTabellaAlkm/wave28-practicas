package products;

public abstract class Product {

    public double price;

    public Product(Double price){
        this.price = price;
    }

    public abstract boolean isFoodReservation();
    public abstract boolean isHotelReservation();
    public abstract boolean isTravelTicket();
    public abstract void applyTwoReservationsDiscount()
}