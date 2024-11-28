public class Main {
    
    public static void main(String[] args) {
           
    }

    public static void TipoDeServicio(){
        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios

        for (int i = 0; i < serviciosCli.length; i++) {
            System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
            System.out.println ("El monto de la factura es de: " + (serviciosCli[i] == 1 ? 1500 : 2100));
        }
    }
    
    public static void EjercicioSueldo()
    {
        double sueldoBase = 21000;
        String dni = "12345678"; 
        double sueldoConAumento = CalcularSueldo(sueldoBase);
        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }

    public static double CalcularSueldo(double sueldoBase)
    {
        if (sueldoBase <= 45000 && sueldoBase > 20000)
            return sueldoBase * 1.10;

        if (sueldoBase > 45000)
            return sueldoBase * 1.05;

        return sueldoBase * 1.20;
    }
}