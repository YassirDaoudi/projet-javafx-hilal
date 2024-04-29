package ma.esi.jfxapp.model;

public class Product {
    private Integer id;
    private String label;
    private Integer quantityInStock;
    private Double price;

    // Constructor
    public Product(Integer id, String label, Integer quantityInStock,Double price) {
        this.id = id;
        this.label = label;
        this.quantityInStock = quantityInStock;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", price=" + price +
                '}';
    }
}
