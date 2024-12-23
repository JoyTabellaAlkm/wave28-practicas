public class Auto extends Vehiculo{

    private static final Double PESO_DE_AUTO = 1000.0;
    public static final int RUEDAS = 4;

    /**
     * Recibimos solo los parametros necesarios para construir nuestra parte vehiculo
     * En el caso de Peso y RUEDAS son fijos para todos los vehiculos
     * @param unaVelocidad
     * @param unaAceleracion
     * @param unAnguloDeGiro
     * @param unaPatente
     */
    public Auto(Double unaVelocidad, Double unaAceleracion, Double unAnguloDeGiro, String unaPatente) {
        super(unaVelocidad, unaAceleracion, unAnguloDeGiro, unaPatente, PESO_DE_AUTO, RUEDAS);
    }

    @Override
    public String toString() {
        return "Auto{" + super.toString();
    }
}
