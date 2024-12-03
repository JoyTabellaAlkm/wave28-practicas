public class Moto extends Vehiculo{
    // es una variable constante que no puede ser modificada (final)
    public static final Double PESO_MOTO = 300.0;
    public static final Integer CANTIDAD_RUEDAS_MOTO = 2;

    /**
     * Recibimos solo los parametros necesarios para construir nuestraparte vehiculo
     * En el caso de Peso y RUEDAS son fijos para todos los moto
     * @param unaVelocidad
     * @param unaAceleracion
     * @param unAnguloDeGiro
     * @param unaPatente
     */
    public Moto(Double unaVelocidad, Double unaAceleracion, Double unAnguloDeGiro, String unaPatente) {
        super(unaVelocidad, unaAceleracion, unAnguloDeGiro, unaPatente, PESO_MOTO, CANTIDAD_RUEDAS_MOTO);
    }

    @Override
    public String toString() {
        return "Moto{" + super.toString();
    }
}
