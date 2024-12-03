import products.FoodReservation;
import products.HotelReservation;
import products.Package;
import products.Product;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        FoodReservation foodReservation = new FoodReservation(10.0);
        FoodReservation foodReservation2 = new FoodReservation(12.0);
        HotelReservation hotelReservation = new HotelReservation(10.0);
        Package aPackage = new Package(10.0, List.of(foodReservation, hotelReservation));
    }
}