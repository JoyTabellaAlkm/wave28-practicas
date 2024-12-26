//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class NoPerecedero extends Producto {
    String tipo;

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + "Tipo: " + this.tipo;
    }

    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }
}
