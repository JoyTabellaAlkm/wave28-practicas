//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SeriePor2 seriePor2 = new SeriePor2(1,2);
        System.out.println(seriePor2.siguienteValor());
        System.out.println(seriePor2.siguienteValor());
        System.out.println(seriePor2.siguienteValor());
        System.out.println(seriePor2.siguienteValor());
        seriePor2.reiniciarValor();
        System.out.println("Reinicio: ");
        System.out.println(seriePor2.siguienteValor());

        System.out.println("Serie por decimal: ");
        SeriePorDecimal seriePorDecimal = new SeriePorDecimal(0.0, 0.5);
        System.out.println(seriePorDecimal.siguienteValor());
        System.out.println(seriePorDecimal.siguienteValor());
        System.out.println(seriePorDecimal.siguienteValor());
        System.out.println(seriePorDecimal.siguienteValor());
        System.out.println(seriePorDecimal.siguienteValor());
        System.out.println(seriePorDecimal.siguienteValor());
        System.out.println(seriePorDecimal.siguienteValor());
        System.out.println(seriePorDecimal.siguienteValor());
        seriePorDecimal.reiniciarValor();
        System.out.println("Reinicio: ");
        System.out.println(seriePorDecimal.siguienteValor());
    }
}