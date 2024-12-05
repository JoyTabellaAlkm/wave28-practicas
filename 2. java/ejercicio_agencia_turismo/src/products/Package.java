package products;

import client.Client;

import java.util.List;

public class Package {
    public List<Product> productList;
    private double price;

    public Package(List<Product> packageProductList) {
        this.productList = packageProductList;
    }

    public void printPackage() {
        productList.forEach(System.out::println);
    }

    public double getPriceForClient(Client client) {
        price = getTotalPriceWithEachProductDiscount();

        if (isFullPackage()) {
            applyDiscountOf(0.1);
        }

        if (client.hasMoreThanOneLocator()) {
            applyDiscountOf(0.5);
        }

        return price;
    }

    private void applyDiscountOf(double discount) {
        price = price - discount * price;
    }

    private double getTotalPriceWithEachProductDiscount() {
        applyTwoHotelsOrTravelsDiscount();
        return getProductsTotalPrice();
    }

    private double getProductsTotalPrice() {
        return productList.stream()
                .map(product -> product.price)
                .reduce(0.0, Double::sum);
    }

    private void applyTwoHotelsOrTravelsDiscount() {
        if (hasTwoHotelReservations() || hasTwoTravelTickets()) {
            productList.forEach(Product::applyTwoReservationsDiscount);
        }
    }

    private boolean isFullPackage() {
        boolean hasFoodReservation = foodReservationsAmount() > 0;
        boolean hasHotelReservation = hotelReservationsAmount() > 0;
        boolean hasTravelTicket = travelTicketsAmount() > 0;

        return hasFoodReservation && hasHotelReservation && hasTravelTicket;
    }

    private boolean hasTwoHotelReservations() {
        return hotelReservationsAmount() == 2;
    }

    private boolean hasTwoTravelTickets() {
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