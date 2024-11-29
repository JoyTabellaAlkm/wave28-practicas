import Entities.Automovil;

public class Main {
    public static void main(String[] args){
        Automovil mobile = new Automovil("Hyundai", "Chrome", 0);
        String toPrint = String.format(
                "This %s %s car has %f kilometres on it! ",
                mobile.color,
                mobile.marca,
                mobile.kilometros
        );

        System.out.println(toPrint);
    }
}
