package ma.esi.jfxapp.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {
    public static boolean save(Order order) {
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("INSERT INTO orders(product_id, qte, id_client) VALUES (?,?,?)")) {
            pstmt.setInt(1, order.getProductId());
            pstmt.setInt(2, order.getQuantity());
            pstmt.setInt(3, order.getClientId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(Integer id) {
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("DELETE FROM orders WHERE id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Order> findByClientId(Integer clientId) throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT * FROM orders WHERE id_client = ?");
        pstmt.setInt(1, clientId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            orders.add(new Order(rs.getInt("id"), rs.getInt("product_id"), rs.getInt("qte"), rs.getInt("id_client")));
        }
        return orders;
    }

    public static ArrayList<Order> findAll() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT * FROM orders");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            orders.add(new Order(rs.getInt("id"), rs.getInt("product_id"), rs.getInt("qte"), rs.getInt("id_client")));
        }
        return orders;
    }
}
