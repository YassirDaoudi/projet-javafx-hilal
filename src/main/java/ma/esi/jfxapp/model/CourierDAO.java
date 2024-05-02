package ma.esi.jfxapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourierDAO {


    public Courier findById(int id) {
        Courier courier = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM couriers WHERE id = ?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                courier = new Courier(rs.getInt("id"), rs.getString("name"), CourierStatus.valueOf(rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courier;
    }

    public boolean delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("DELETE FROM couriers WHERE id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Courier> findAll() throws SQLException {
        ArrayList<Courier> couriers = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM couriers")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                couriers.add(new Courier(rs.getInt("id"), rs.getString("name"), CourierStatus.getByValue(rs.getString("status"))));
            }
        }
        return couriers;
    }

    public boolean save(Courier courier){
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("INSERT INTO couriers(name, status) VALUES (?,?)")){
            pstmt.setString(1,courier.getName());
            pstmt.setString(2,courier.getStatus().value);
            pstmt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
