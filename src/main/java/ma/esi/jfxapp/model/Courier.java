package ma.esi.jfxapp.model;

import java.sql.PreparedStatement;

public class Courier {
    private Integer id;
    private String name;
    private CourierStatus status;

    // Constructor
    public Courier(Integer id, String name, CourierStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public boolean update(Integer id){
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("UPDATE couriers set name = ?,status  =? where id=?")){
            pstmt.setString(1, getName());
            pstmt.setString(2, getStatus().value);
            pstmt.setInt(3,id);
            pstmt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourierStatus getStatus() {
        return status;
    }

    public void setStatus(CourierStatus status) {
        this.status = status;
    }

    // toString method for easy prIntegering
    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
