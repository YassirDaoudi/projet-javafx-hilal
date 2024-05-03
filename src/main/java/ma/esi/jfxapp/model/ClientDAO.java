package ma.esi.jfxapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO  {
    public boolean save(Client client){
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("INSERT INTO clients(name, address, email, tel) VALUES (?,?,?,?)")){
            pstmt.setString(1,client.getName());
            pstmt.setString(2,client.getAddress());
            pstmt.setString(3,client.getEmail());
            pstmt.setString(4,client.getTel());
            pstmt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer id){
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("DELETE FROM clients where id = ?")){
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Client> find(String email) throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT * FROM clients where email = ?");
        pstmt.setString(1,email);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            clients.add(new Client(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getString("email"),rs.getString("tel")));
        }
        return clients;
    }

    public boolean delete(String email){
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("DELETE FROM clients where email = ?")){
            pstmt.setString(1,email);
            pstmt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Client> findAll() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("SELECT * FROM clients;");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            clients.add(new Client(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getString("email"),rs.getString("tel")));
        }
        return clients;
    }
    public void update(Client client) throws SQLException {
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement("UPDATE clients set name=?,address=?,email=?,tel=? where id=? ")){
            pstmt.setString(1, client.getName());
            pstmt.setString(2, client.getAddress());
            pstmt.setString(3, client.getEmail());
            pstmt.setString(4, client.getTel());
            pstmt.setInt(5, client.getId());
            pstmt.executeUpdate();
        }
    }
}
