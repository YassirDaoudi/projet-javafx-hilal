package ma.esi.jfxapp.model;

import java.util.ArrayList;

public class Invoice {
    private Integer id;
    private double total;
    private DeliveryType deliveryType;
    private Integer clientId;
    private Integer deliveryId;
    private ArrayList<Order> orders;

    public Invoice(Integer id, double total, DeliveryType deliveryType, Integer clientId, Integer deliveryId) {
        this.id = id;
        this.total = total;
        this.deliveryType = deliveryType;
        this.clientId = clientId;
        this.deliveryId = deliveryId;
    }

    @Override
    public String toString() {
        return "Invoice ID: " + id + "\nTotal: $" + total + "\nDelivery Type: " + deliveryType + "\nClient ID: " + clientId + "\nDelivery ID: " + deliveryId;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }
}

