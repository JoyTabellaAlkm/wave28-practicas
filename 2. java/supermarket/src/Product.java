public class Product {
    private String code;
    private String name;
    private Integer quantity;
    private Double cost;

    public Product(String code, String name, Integer quantity, Double cost) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                " code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                '}';
    }
}
