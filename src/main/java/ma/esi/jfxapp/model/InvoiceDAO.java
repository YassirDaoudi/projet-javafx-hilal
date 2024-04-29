package ma.esi.jfxapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDAO {
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
