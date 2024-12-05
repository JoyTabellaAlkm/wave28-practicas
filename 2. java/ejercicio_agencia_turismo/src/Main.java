import client.Client;
import client.ClientRepository;
import products.*;
import products.Package;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FoodReservation foodReservation = new FoodReservation(300.0);
        HotelReservation hotelReservation = new HotelReservation(200.0);
        TravelTicket travelTicket = new TravelTicket(500.0);

        Package fullPackage = new Package(List.of(foodReservation, hotelReservation, travelTicket));

        ClientRepository clientRepository = new ClientRepository();
        Client johnDoe = new Client("John Doe");
        clientRepository.add(johnDoe);

        System.out.println("Precio final del paquete: " + johnDoe.getFinalPriceFor(fullPackage));
        fullPackage.printPackage();

        johnDoe.buy(fullPackage);


        HotelReservation hotelReservation2 = new HotelReservation(200.0);
        TravelTicket travelTicket2 = new TravelTicket(500.0);
        HotelReservation hotelReservation3 = new HotelReservation(200.0);
        TravelTicket travelTicket3 = new TravelTicket(500.0);
        Package aPackage = new Package(List.of(
                hotelReservation2,
                hotelReservation3,
                travelTicket2,
                travelTicket3
        ));

        System.out.println("Precio final del paquete: " + johnDoe.getFinalPriceFor(aPackage));
        aPackage.printPackage();

        johnDoe.buy(aPackage);
    }
}