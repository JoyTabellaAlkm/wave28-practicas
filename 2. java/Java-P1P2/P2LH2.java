public class P2LH2 {
	public static void main(String[] args) {
		int serviciosCli[] = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
		double totalFactura = 0;

		for (int i=0; i < serviciosCli.length; i++) {
		  if (serviciosCli[i] == 2) {
		     totalFactura += 2200;
		     System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
		     System.out.println ("El monto de la factura es de: " + totalFactura);
		  }
		  else {
		     totalFactura += 1500;
		     System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
		     System.out.println ("El monto de la factura es de: " + totalFactura);
		  }
		}
	}
}
