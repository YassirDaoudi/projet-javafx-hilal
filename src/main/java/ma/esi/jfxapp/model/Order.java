package ma.esi.jfxapp.model;

import java.sql.SQLException;

public class Order {
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private Double total;
    private Integer invoiceId;

    // Constructor
    public Order(Integer id, Integer productId, Integer quantity, Double total, Integer invoiceId) throws SQLException {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.invoiceId = invoiceId;
        this.total = total;
    }
    public Order(Integer id, Integer productId, Integer quantity, Integer invoiceId) throws SQLException {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.invoiceId = invoiceId;
        this.total = Math.round(quantity * new ProductDAO().getPrice(productId) * 100.)/100.;
    }




    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
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


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", invoiceId=" + invoiceId +
                '}';
    }
}
