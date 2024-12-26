//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Perecedero extends Producto {
    int diasPorCalducar;

    public int getDiasPorCalducar() {
        return this.diasPorCalducar;
    }

    public void setDiasPorCalducar(int diasPorCalducar) {
        this.diasPorCalducar = diasPorCalducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCalducar) {
        super(nombre, precio);
        this.diasPorCalducar = diasPorCalducar;
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + "Dias por caducar: " + this.diasPorCalducar;
    }

    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);
        if (this.diasPorCalducar == 1) {
            precioFinal -= precioFinal * 0.4;
        } else if (this.diasPorCalducar == 2) {
            precioFinal -= precioFinal * 0.3;
        } else if (this.diasPorCalducar == 3) {
            precioFinal /= (double)2.0F;
        }

        return precioFinal;
    }
}
