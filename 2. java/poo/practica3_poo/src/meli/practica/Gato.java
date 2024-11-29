package meli.practica;

public class Gato extends Animal {
    
    private String nombre;

    public String getNombre(){
        return nombre;
    }

    public void getNombre(string nombre){
        this.nombre = nombre;
    }

    public Gato(String especie, String nombre){
        super(especie);
        this.nombre = nombre;
    }

    @Override
    public woid mostrarEspecie(){
        super.mostrarEspecie();
        System.out.println("Soy un gato que maulla");
    }

    @Override
    public void hacerSonido(){
        System.out.println("Miau");
    }
}
