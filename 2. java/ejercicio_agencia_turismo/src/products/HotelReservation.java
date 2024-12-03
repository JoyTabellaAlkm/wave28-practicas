package products;

public class HotelReservation extends Product {
    public HotelReservation(Double price) {
        super(price);
    }

    @Override
    public boolean isFoodReservation() {
        return false;
    }

    @Override
    public boolean isHotelReservation() {
        return true;
    }

    @Override
    public boolean isTravelTicket() {
        return false;
    }

    @Override
    public String toString() {
        return "HotelReservation{" +
                "price=" + price +
                '}';
    }

    public void applyTwoReservationsDiscount(){
        price =  price - 0.1 * price;
    }
}
