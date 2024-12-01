package Ejercicio2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Object categoria1= new Object(){
            int id= 1;
            String nombre ="Circuito chico" ;
            String descripcion= "2Km por selva y arroyo";
            String getNombre() {
                return nombre;
            }
        };

        Object categoria2= new Object(){
            int id= 2;
            String nombre ="Circuito medio" ;
            String descripcion= "5Km por selva ,arroyo y barro";
        };

        Object categoria3= new Object(){
            int id= 3;
            String nombre ="Circuito avanzado" ;
            String descripcion= "10Km por selva , arroyo, barro y escalada en piedra";
        };


        Object participante1= new Object(){
            int numero= 1;
            int dni= 12345;
            int edad= 33;
            String nombre ="Juan" ;
            String apellido="Perez";
            String celular ="15675839393";
            String numEmergencia= "911";
            String grupoSanguinio= "A+";
        };


        Object Inscripción= new Object(){
            int numero;
            int idCategoria;
            int dni;
            double monto;
        };



    }
}