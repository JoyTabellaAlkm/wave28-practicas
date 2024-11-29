public class Distribuidora {
    public static void main(String[] args) {
        NoPerecedero Producto1 = new NoPerecedero("superHuevo", 10, "superHuevo");
        Perecedero Producto2 = new Perecedero("Huevo", 12, 1);
        NoPerecedero Producto3 = new NoPerecedero("superHuevo", 10, "superHuevo");
        NoPerecedero Producto4 = new NoPerecedero("superHuevo", 10, "superHuevo");
        NoPerecedero Producto5 = new NoPerecedero("superHuevo", 10, "superHuevo");


        Poducto poductos[] = {Producto1, Producto2, Producto3, Producto4, Producto5};

        for (Poducto p : poductos) {
            System.out.println(p.calcular(1));
            System.out.println(p.toString());
        }
    }
}