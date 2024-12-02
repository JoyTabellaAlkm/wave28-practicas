public class Gato extends Animal implements ICarnivoro{

    public Gato(String nombre){
        super(nombre);
    }

    @Override
    public void emitirSonido(){
        System.out.println("Miau");
    }

    @Override
    public void comerCarne(){
        System.out.println(this.getNombre() + " come poca carne de: res, pollo, pavo, hígado y cordero");
    }
}
