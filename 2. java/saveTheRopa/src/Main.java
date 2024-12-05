import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garment shirt = new Garment("Adidas", "Classic");
        Garment pants = new Garment("Americano", "Slim");
        Checkroom checkroom = new Checkroom();

        Integer code = checkroom.storeGarments(List.of(shirt, pants));
        System.out.printf("\nSe han almacenado sus prendas con el identificador %d\n", code);

        Garment shoes = new Garment("Nike", "Urban");
        Garment sneakers = new Garment("Puma", "Sport");
        Garment dress = new Garment("Victoria", "Long");

        checkroom.storeGarments(List.of(shoes, sneakers, dress));

        System.out.println("\nTotal prendas almacenadas en el guarda ropa");
        checkroom.showGarments();

        System.out.println("\nConsulta por identificador");
        List<Garment> garments = checkroom.returnGarments(2);
        if (garments == null){
            System.out.println("No hay prendas en el guardarropa con ese identificador");
        } else System.out.println(garments);









    }
}