// Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int. 
// Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje 
// “Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje “Programa finalizado”

// Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el mensaje 
// “Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el mensaje 
// “No se puede dividir por cero”

public class PracticaExcepciones {
    public static void main(String[] args) {
        PracticaExcepciones excep = new PracticaExcepciones();
        excep.calcCociente();
    }
    int a=0;
    int b=300;
    public void calcCociente(){
        try{
            if(a==0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            double cociente = b/a;
            System.out.println("El resultado del cociente es: "+cociente); 
        }catch(IllegalArgumentException e){
            //catch(ArithmeticException e)
            //System.out.println("Se ha producido un error");
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Programa finalizado");
        }
        
    }
}
