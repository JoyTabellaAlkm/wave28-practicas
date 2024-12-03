package products;

public class TravelTicket extends Product {
    public TravelTicket(Double price) {
        super(price);
    }

    @Override
    public boolean isFoodReservation() {
        return false;
    }

    @Override
    public boolean isHotelReservation() {
        return false;
    }

    @Override
    public boolean isTravelTicket() {
        return true;
    }

    @Override
    public String toString() {
        return "TravelTicket{" +
                "price=" + price +
                '}';
    }

    public void applyTwoReservationsDiscount(){
        price =  price - 0.1 * price;
    }
}
