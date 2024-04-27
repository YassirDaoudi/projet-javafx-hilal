package ma.esi.jfxapp.model;

public class Order {
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private Integer clientId;

    // Constructor
    public Order(Integer id, Integer productId, Integer quantity, Integer clientId) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.clientId = clientId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    // toString method
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", clientId=" + clientId +
                '}';
    }
}
