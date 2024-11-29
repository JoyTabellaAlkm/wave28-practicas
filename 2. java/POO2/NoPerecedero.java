public class NoPerecedero extends Producto {

    protected String type;

    public NoPerecedero(String name, double price, String type){
        super(name, price);
        this.type = type;
    }

    //setter
    public void setType(String type) {
        this.type = type;
    }

    //getter
    public String getType() {
        return type;
    }

    @Override
    public String toString(){
        return """
                Nombre: %s,
                Precio: %s,
                Tipo: %s
                """.formatted(this.name, this.price, this.type);
    }
}
