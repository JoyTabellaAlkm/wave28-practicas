package products;
import java.util.List;

public class Package {
    public List<Product> productList;

    public Package(List<Product> packageProductList){
        this.productList = packageProductList;
    }

    public void printPackage() {
        productList.forEach(System.out::println);
    }

    public double getPrice() {
        if (hasTwoHotelReservations() || hasTwoTravelTickets()) {
            productList.forEach(Product::applyTwoReservationsDiscount);
        }

        double totalPrice = productList.stream()
                .map(product -> product.price)
                .reduce(0.0, Double::sum);

        if (isFullPackage()) {
            totalPrice = totalPrice - 0.1 * totalPrice;
        }

        return totalPrice;
    }

    public boolean isFullPackage() {
        boolean hasFoodReservation = foodReservationsAmount() > 0;
        boolean hasHotelReservation = hotelReservationsAmount() > 0;
        boolean hasTravelTicket = travelTicketsAmount() > 0;

        return hasFoodReservation && hasHotelReservation && hasTravelTicket;
    }

    public boolean hasTwoHotelReservations() {
        return hotelReservationsAmount() == 2;
    }

    public boolean hasTwoTravelTickets() {
        return travelTicketsAmount() == 2;
    }

    private List<Product> foodReservations() {
        return productList.stream()
                .filter(Product::isFoodReservation)
                .toList();
    }

    private int foodReservationsAmount() {
        return productList.stream()
                .filter(Product::isFoodReservation)
                .toList()
                .size();
    }

    private int hotelReservationsAmount() {
        return productList.stream()
                .filter(Product::isHotelReservation)
                .toList()
                .size();
    }

    private int travelTicketsAmount() {
        return productList.stream()
                .filter(Product::isTravelTicket)
                .toList()
                .size();
    }
}