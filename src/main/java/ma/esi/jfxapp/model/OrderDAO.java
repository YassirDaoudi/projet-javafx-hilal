package ma.esi.jfxapp.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {

    public boolean delete(Integer id) {
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("DELETE FROM orders WHERE id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public ArrayList<Order> findAll() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT * FROM orders");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            orders.add(new Order(rs.getInt("id"), rs.getInt("product_id"), rs.getInt("qte"),rs.getDouble("total"),rs.getInt("invoice_id")));
        }
        return orders;
    }

    public boolean save(Order order) {
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("INSERT INTO orders(product_id, qte,total,invoice_id) VALUES (?,?,?,?)")) {
            pstmt.setInt(1, order.getProductId());
            pstmt.setInt(2, order.getQuantity());
            pstmt.setDouble(3, order.getTotal());
            pstmt.setInt(4, order.getInvoiceId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
