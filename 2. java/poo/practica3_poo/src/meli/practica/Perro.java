package meli.practica;

public class Perro extends Animal {
    
    private String nombre;

    public String getNombre(){
        return nombre;
    }

    public void getNombre(string nombre){
        this.nombre = nombre;
    }

    public Perro(String especie, String nombre){
        super(especie);
        this.nombre = nombre;
    }

    @Override
    public woid mostrarEspecie(){
        super.mostrarEspecie();
        System.out.println("Soy un perro que ladra");
    }

    @Override
    public void hacerSonido(){
        System.out.println("Guau");
    }
}
