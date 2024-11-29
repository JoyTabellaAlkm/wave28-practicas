public class Main {
    public static void main(String[] args) {
        Producto[] productos = {
                new Perecedero(2, "Banana", 3.50),
                new Perecedero(8, "leche", 6.45),
                new Perecedero(4, "yogurt", 4.80),
                new Perecedero(1, "chocolate", 2.25),
                new Perecedero(6, "tomate", 4.30),
                new NoPerecedero("Lata", "choclo", 5.0),
                new NoPerecedero("Paquete", "arroz", 7.35),
                new NoPerecedero("Paquete", "choclo", 4.32),
                new NoPerecedero("Lata", "arvejas", 6.54),
                new NoPerecedero("Tetra", "Pure de tomate", 5.55)
        };

        Double total = 0.0;
        Double totalPerecedero = 0.0;
        Double totalNoPerecedero = 0.0;
        Double calculo = 0.0;
        for (Producto producto : productos) {
            calculo = producto.calcular((int) (Math.random() * 10) + 1);
            total += calculo;
            if(producto.getClass().getName().equals("Perecedero") ){
                totalPerecedero += calculo;
            }else{
                totalNoPerecedero += calculo;
            }

        }
        System.out.println("Total: " + total);
        System.out.println("Total Perecedero: " + totalPerecedero);
        System.out.println("Total No Perecedero: " + totalNoPerecedero);
    }
}