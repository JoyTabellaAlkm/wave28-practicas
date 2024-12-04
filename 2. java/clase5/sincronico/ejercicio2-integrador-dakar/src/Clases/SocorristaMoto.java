package Clases;

import Interfaces.ISocorrista;

public class SocorristaMoto implements ISocorrista {
    @Override
    public void socorrer(Vehiculo moto) {

        System.out.println("Socorriendo moto " + moto.getPatente() );
    }
}