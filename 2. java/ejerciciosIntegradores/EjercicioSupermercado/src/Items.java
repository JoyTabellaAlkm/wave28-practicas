public class Items {
    String name;
    Double precio;

    public Items(String name, Double precio) {
        this.name = name;
        this.precio = precio;
    }

    public Items() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", precio=" + precio +
                '}';
    }
}

