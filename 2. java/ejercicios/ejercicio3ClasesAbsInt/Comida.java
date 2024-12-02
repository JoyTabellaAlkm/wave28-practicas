package ejercicios.ejercicio3ClasesAbsInt;

public interface Comida {
    default String comerCarne(){
        return "Carnivoro";
    };
}
