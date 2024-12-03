//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Prototipo<Integer> serieDeADos = new SerieEntera();
        try {
            serieDeADos.setValorInicialSerie(2);
            System.out.println(serieDeADos.getSiguienteValorSerie());
            System.out.println(serieDeADos.getSiguienteValorSerie());
            serieDeADos.reiniciarSerie();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Prototipo<Double> serieDeATres = new SerieDouble();
        try {
            serieDeATres.setValorInicialSerie(3.0);
            System.out.println(serieDeATres.getSiguienteValorSerie());
            System.out.println(serieDeATres.getSiguienteValorSerie());
            serieDeATres.reiniciarSerie();
            System.out.println(serieDeATres.getSiguienteValorSerie());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}