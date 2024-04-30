package ma.esi.jfxapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDAO {
    public static boolean save(Invoice invoice) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO invoices(total, del_type, client_id, delivery_id) VALUES (?, ?, ?, ?)")) {
            pstmt.setDouble(1, invoice.getTotal());
            pstmt.setString(2, invoice.getDeliveryType().value);
            pstmt.setInt(3, invoice.getClientId());
            pstmt.setInt(4, invoice.getDeliveryId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("DELETE FROM invoices WHERE id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Invoice> findAll() throws SQLException {
        ArrayList<Invoice> invoices = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM invoices")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setId(rs.getInt("id"));
                invoice.setTotal(rs.getDouble("total"));
                // Assuming deliveryType is stored as a string in the database
                invoice.setDeliveryType(DeliveryType.getByString(rs.getString("del_type")));
                invoice.setClientId(rs.getInt("client_id"));
                invoice.setDeliveryId(rs.getInt("delivery_id"));
                invoices.add(invoice);
            }
        }
        return invoices;
    }


    public static Invoice findById(int id) {
        Invoice invoice = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM invoices WHERE id = ?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                invoice = new Invoice();
                invoice.setId(rs.getInt("id"));
                invoice.setTotal(rs.getDouble("total"));
                // Assuming deliveryType is stored as a string in the database
                invoice.setDeliveryType(DeliveryType.valueOf(rs.getString("del_type")));
                invoice.setClientId(rs.getInt("client_id"));
                invoice.setDeliveryId(rs.getInt("delivery_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoice;
    }
    public static ArrayList<Order> getOrders(Integer invoiceId) throws SQLException {
        try (Connection con = DBConnection.getConnection()){
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM orders where invoice_id= ?;");
            pstmt.setInt(1,invoiceId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Order> orders = new ArrayList<>();
            if (!rs.isBeforeFirst()) throw new SQLException("Not found : empty invoice");
            while (rs.next()) {
                orders.add(new Order(rs.getInt("id"),rs.getInt("product_id"),rs.getInt("qte"),rs.getDouble("total"),rs.getInt("invoice_id")));
            }
            return orders;
        }
    }
    public static Delivery getDelivery(Integer deliveryId) throws SQLException {
        try (Connection con = DBConnection.getConnection()){
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM deliveries where id= ?;");
            pstmt.setInt(1,deliveryId);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.isBeforeFirst()) throw new SQLException("Not found : empty invoice");
            return new Delivery(rs.getInt("id"),rs.getString("address"),rs.getDate("date"),rs.getInt("courier_id"));
        }
    }
}
