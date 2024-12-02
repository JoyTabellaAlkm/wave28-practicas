public class Documento implements IImprimible{

    private String documento;

    public Documento(String documento) {
        this.documento = documento;
    }

    @Override
    public void imprimirDocumento(String documento) {
        System.out.println("Imprimiendo documento: " + documento);
    }

    @Override
    public void imprimirTipoDoc() {
        System.out.println("Imprimiendo tipo de docu");
    }
}
