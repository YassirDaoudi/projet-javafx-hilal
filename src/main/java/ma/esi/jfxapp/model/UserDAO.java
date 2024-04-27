package ma.esi.jfxapp.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    public static boolean save(User user) {
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("INSERT INTO users(fullname, email, password, tel) VALUES (?,?,?,?)")) {
            pstmt.setString(1, user.getFullname());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getTel());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(Integer id) {
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("DELETE FROM users WHERE id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<User> findAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT * FROM users")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"), rs.getString("password"), rs.getString("tel")));
            }
        }
        return users;
    }
    public static ArrayList<User> findByEmailAndPassword(String email , String password) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT * FROM users where email=? and password=?")) {
            pstmt.setString(1,email);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"), rs.getString("password"), rs.getString("tel")));
            }
        }
        return users;
    }
}
