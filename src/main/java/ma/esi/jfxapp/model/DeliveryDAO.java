package ma.esi.jfxapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveryDAO {

    public ArrayList<Delivery> findAll() throws SQLException {
        ArrayList<Delivery> deliveries = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM deliveries")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(rs.getInt("id"));
                delivery.setAddress(rs.getString("address"));
                delivery.setDate(rs.getDate("date"));
                delivery.setCourierId(rs.getInt("courier_id"));
                deliveries.add(delivery);
            }
        }
        return deliveries;
    }

    public Delivery findById(int id) {
        Delivery delivery = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM deliveries WHERE id = ?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                delivery = new Delivery();
                delivery.setId(rs.getInt("id"));
                delivery.setAddress(rs.getString("address"));
                delivery.setDate(rs.getDate("date"));
                delivery.setCourierId(rs.getInt("courier_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delivery;
    }

    public boolean delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("DELETE FROM deliveries WHERE id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Delivery delivery) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("UPDATE deliveries SET address = ?, date = ?, courier_id = ? WHERE id = ?")) {
            pstmt.setString(1, delivery.getAddress());
            pstmt.setDate(2, new java.sql.Date(delivery.getDate().getTime()));
            pstmt.setInt(3, delivery.getCourierId());
            pstmt.setInt(4, delivery.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean save(Delivery delivery) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO deliveries(address, date, courier_id) VALUES (?, ?, ?)")) {
            pstmt.setString(1, delivery.getAddress());
            pstmt.setDate(2, new java.sql.Date(delivery.getDate().getTime()));
            pstmt.setInt(3, delivery.getCourierId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
