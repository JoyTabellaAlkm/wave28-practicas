package bootcamp;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String name, double price, int diasPorCaducar) {
        super(name, price);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calculate(int quantity) {
        double finalPrice = super.calculate(quantity);

        switch (diasPorCaducar) {
            case 1:
                finalPrice = finalPrice / 4;
                break;
            case 2:
                finalPrice = finalPrice / 3;
                break;
            case 3:
                finalPrice = finalPrice / 2;
                break;
            default:
                break;
        }

        return finalPrice;
    }
}
