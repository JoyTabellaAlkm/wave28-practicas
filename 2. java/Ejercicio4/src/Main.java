//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PracticaExepciones practica = new PracticaExepciones();
        try {int division = practica.divide();} catch (Exception e) {System.out.println(e.getMessage());}
        finally {System.out.println("Programa finalizado");}
    }
}