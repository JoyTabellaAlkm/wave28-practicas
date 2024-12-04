package Clases;

import Interfaces.ISocorrista;

public class Socorrista implements ISocorrista {
    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo " + (vehiculo.getClass().equals(Auto.class) ? "auto " : "moto ") + "de patente: " + vehiculo.getPatente());
    }

}
