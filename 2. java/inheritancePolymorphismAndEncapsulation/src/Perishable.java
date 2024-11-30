public class Perishable extends Product{
    private int daysToExpire;

    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculate(int quantityOfProducts) {
        double totalPrice = super.calculate(quantityOfProducts);
        if (daysToExpire <= 1){
            totalPrice /= 4;
        } else if (daysToExpire == 2) {
            totalPrice /= 3;
        } else if (daysToExpire == 3) {
            totalPrice /= 2;
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        return super.toString() + " Perishable{" +
                "daysToExpire=" + daysToExpire +
                '}';
    }
}
