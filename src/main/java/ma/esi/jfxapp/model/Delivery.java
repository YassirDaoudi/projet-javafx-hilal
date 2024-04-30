package ma.esi.jfxapp.model;

import java.sql.Date;

public class Delivery {
    private Integer id;
    private String address;
    private Date date;
    private Integer courierId;

    // Constructor
    public Delivery(Integer id, String address, Date date, Integer courierId) {
        this.id = id;
        this.address = address;
        this.date = date;
        this.courierId = courierId;
    }

    public Delivery() {

    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }

    // toString method for easy prIntegering
    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", courierId=" + courierId +
                '}';
    }
}
