package ejercicios.clasesAbstractasInterfaces.ejercicio3ClasesAbsInt;

public class Vaca extends Animal{
    @Override
    public String emitirSonido() {
        return "Muuu";
    }

    public String comerHierba(){
        return "Herbiboro";
    }

    public String comer() {
        return this.comerHierba();
    }
}
