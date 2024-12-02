package com.company;

public abstract class Animal {
    boolean carnivoro;

    public boolean isCarnivoro() {
        return carnivoro;
    }

    public void setCarnivoro(boolean carnivoro) {
        this.carnivoro = carnivoro;
    }

    public Animal(boolean carnivoro) {
        this.carnivoro = carnivoro;
    }

    public abstract void emitirSonido();
    public void comer() {
        String mensaje = carnivoro == true ? "Comer Carne" : "Comer hierva";
        System.out.println(mensaje);
    }
}
