package products;

public class FoodReservation extends Product {
    public FoodReservation(Double price) {
        super(price);
    }

    @Override
    public boolean isFoodReservation() {
        return true;
    }

    @Override
    public boolean isHotelReservation() {
        return false;
    }

    @Override
    public boolean isTravelTicket() {
        return false;
    }

    @Override
    public void applyTwoReservationsDiscount() {
    }

    @Override
    public String toString() {
        return "FoodReservation{" +
                "price=" + price +
                '}';
    }
}
