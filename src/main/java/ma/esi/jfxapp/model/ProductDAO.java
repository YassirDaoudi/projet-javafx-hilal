package ma.esi.jfxapp.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
    public static boolean save(Product product){
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("INSERT INTO products(id, label, qt_in_stock,price) VALUES (?,?,?,?)")){
            pstmt.setInt(1, product.getId());
            pstmt.setString(2, product.getLabel());
            pstmt.setInt(3, product.getQuantityInStock());
            pstmt.setDouble(4, product.getPrice());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static Double getPrice(Integer productId ) throws SQLException {
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT price from products where id = ?")){
            pstmt.setDouble(1,productId);
            ResultSet rs =pstmt.executeQuery();
            if (!rs.isBeforeFirst()) {
                throw new SQLException("Not found :No such product");
            }
            rs.next();
            return rs.getDouble("price");
        }
    }
    public static boolean delete(Integer id){
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("DELETE FROM products WHERE id = ?")){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(String label){
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("DELETE FROM products WHERE label = ?")){
            pstmt.setString(1, label);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static ArrayList<Product> find(String label) throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT * FROM products WHERE label = ?");
        pstmt.setString(1, label);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            products.add(new Product(rs.getInt("id"), rs.getString("label"), rs.getInt("qt_in_stock"),rs.getDouble("price")));
        }
        return products;
    }

    public static ArrayList<Product> findAll() throws SQLException {
        ArrayList<Product> products = new ArrayList<>();
        PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT * FROM products");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            products.add(new Product(rs.getInt("id"), rs.getString("label"), rs.getInt("qt_in_stock"),rs.getDouble("price")));
        }
        return products;
    }

}
