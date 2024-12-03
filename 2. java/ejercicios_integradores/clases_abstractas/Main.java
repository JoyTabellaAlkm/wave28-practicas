package ejercicios_integradores.clases_abstractas;

public class Main {
    public static void main(String[] args) {
        SequenceInteger sI = new SequenceInteger(2);
        System.out.println(sI.next());
        System.out.println(sI.next());
        System.out.println(sI.next());
        System.out.println(sI.next());

        SequenceDouble sD = new SequenceDouble(2.5);
        System.out.println(sD.next());
        System.out.println(sD.next());
        System.out.println(sD.next());
        System.out.println(sD.next());
    }
}
