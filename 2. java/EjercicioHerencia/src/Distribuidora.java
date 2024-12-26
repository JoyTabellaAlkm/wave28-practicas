//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Distribuidora {
    public Distribuidora() {
    }

    public static void main(String[] args) {
        Producto[] productos = new Producto[]{new Perecedero(" Leche ", (double)1000.0F, 1), new Perecedero(" Quesito ", (double)5000.0F, 3), new Perecedero(" Cola&Pola ", (double)7450.0F, 2), new NoPerecedero(" Garbanzo ", (double)5600.0F, " Grano"), new NoPerecedero(" Aceite ", (double)2300.0F, " Aceite"), new NoPerecedero(" Frijoles ", (double)3850.0F, " Grano")};
        System.out.println("Productos: ");

        for(Producto producto : productos) {
            System.out.println(producto.toString());
        }

        double totalPerecedero = (double)0.0F;
        double totalNoPerecedero = (double)0.0F;

        for(int i = 0; i < 3; ++i) {
            totalPerecedero += productos[i].calcular(5);
        }

        for(int i = 3; i < 6; ++i) {
            totalNoPerecedero += productos[i].calcular(5);
        }

        System.out.println("Total de los perecederos: " + totalPerecedero);
        System.out.println("Total de los no perecederos: " + totalNoPerecedero);
    }
}
