package Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args){

        List<Producto> listaDeproductosNoPerecedero = new ArrayList<>();
        listaDeproductosNoPerecedero.add(new NoPerecedero("Arroz", 10.100, "Cereales y grano"));
        listaDeproductosNoPerecedero.add(new NoPerecedero("Pasta", 20.900, "Cereales y grano"));
        listaDeproductosNoPerecedero.add(new NoPerecedero("Quinoa", 9100, "Cereales y grano"));
        listaDeproductosNoPerecedero.add(new NoPerecedero("Avena", 6100, "Cereales y grano"));
        listaDeproductosNoPerecedero.add(new NoPerecedero("Atún", 7100, "Conservas de pescado"));

        List<Producto> listaDeproductosPercedero = new ArrayList<>();
        listaDeproductosPercedero.add(new Perecedero("Yogurt griego", 9200, 1));
        listaDeproductosPercedero.add(new Perecedero("Leche entera liquida", 20.900, 2));
        listaDeproductosPercedero.add(new Perecedero("Yogurt Natural", 9100, 1));
        listaDeproductosPercedero.add(new Perecedero("Queso en barra", 6100, 3));
        listaDeproductosPercedero.add(new Perecedero("Jugo de Manzana", 7100, 2));

        double totalDeproductosNoPercederos = 0;

        for(Producto producto: listaDeproductosNoPerecedero){
            totalDeproductosNoPercederos += producto.calcular(1);
            System.out.printf(
                            "Nombre del producto: %s\n"+
                            "Precio del producto: %,.2f\n" +
                            "--------------------------\n"
                    , producto.nombre, producto.precio
            );
        }

        double totalDeproductosPercederos = 0;
        for(Producto producto: listaDeproductosPercedero){
            System.out.printf(
                            "Nombre del producto: %s\n"+
                            "Precio del producto: %,.2f\n"+
                            "Precio con descuento: %,.2f\n" +
                            "--------------------------\n"
                    , producto.nombre, producto.precio,  producto.calcular(1)
            );
            totalDeproductosPercederos += producto.calcular(1);
        }

        System.out.println("Total a pagar por productos no percederos: "+totalDeproductosNoPercederos);
        System.out.println("Total con descuesto incluido de productos NO percedero proximos a vencer: "+totalDeproductosPercederos);

        System.out.println("Total a pagar::: " + (totalDeproductosPercederos+totalDeproductosNoPercederos));

    }
}
