import client.Client;
import client.ClientRepository;
import products.*;
import products.Package;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FoodReservation foodReservation = new FoodReservation(100.0);
        HotelReservation hotelReservation = new HotelReservation(200.5);
        TravelTicket travelTicket = new TravelTicket(500.50);

        Package aPackage = new Package(List.of(foodReservation, hotelReservation, travelTicket));

        ClientRepository clientRepository = new ClientRepository();
        Client johnDoe = new Client("John Doe");
        clientRepository.add(johnDoe);
        johnDoe.buy(aPackage);

        aPackage.printPackage();
    }
}