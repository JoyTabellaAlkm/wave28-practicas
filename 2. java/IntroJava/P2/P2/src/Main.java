//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainP2 {
    public static void main(String[] args) {
        //EJERCICIOS ASINCRONICOS
        double sueldoBase = 45000; //monto de ejemplo
        String dni ="12345678"; //dni de ejemplo
        double sueldoConAumento;

        int veintePorcentajeAumento = 20;
        int diezPorcentajeAumento = 10;
        int cincoPorcentajeAumento = 5;

        int sueldoVeinteMil = 20000;
        int sueldoCuarentaycinco = 45000;

        if (sueldoBase <= sueldoVeinteMil) {

            sueldoConAumento = (sueldoBase * veintePorcentajeAumento / 100) + sueldoBase;
        }
        else {
            if (sueldoBase <= sueldoCuarentaycinco){
                sueldoConAumento = (sueldoBase * diezPorcentajeAumento / 100) + sueldoBase;
            }
            else {
                sueldoConAumento = (sueldoBase * cincoPorcentajeAumento / 100) + sueldoBase;

            }
        }
        System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);



        int []serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;


        int servicioPratrullaje = 700;

        for (int i = 0; i < serviciosCli.length; i++) {
            totalFactura = 1500;
            if (serviciosCli[i] == 1) {
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura += servicioPratrullaje;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }

    }
}