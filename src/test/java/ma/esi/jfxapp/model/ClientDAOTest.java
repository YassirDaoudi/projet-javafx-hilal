package ma.esi.jfxapp.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientDAOTest {

    @Test
    void save() {
        Client client = new Client(1,"Mr client","Nowhere Street","client@client.com","0522539236");
        assertTrue(ClientDAO.save(client));
        ClientDAO.delete("client@client.com");

    }

    @Test
    void deleteId() {

        try {
            DBConnection.getConnection().createStatement().executeUpdate("INSERT into clients values (99999,'sdfd','fadf','adfaf','adfdf')");
            assertTrue(ClientDAO.delete(99999));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void deleteEmail() {
        try {
            DBConnection.getConnection().createStatement().executeUpdate("INSERT into clients(name, address, email, tel) values ('sdfd','fadf','email','adfdf')");
            assertTrue(ClientDAO.delete("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void find() throws SQLException {
        DBConnection.getConnection().createStatement().executeUpdate("INSERT into clients(id,name, address, email, tel) values (9999999,'sdfd','fadf','email','adfdf')");
        Client client = new Client(9999999,"sdfd","fadf","email","adfdf");
        Client client1 = ClientDAO.find(client.getEmail()).get(0);
        assertEquals(client1, client);
        assertTrue(ClientDAO.find("").isEmpty());
        ClientDAO.delete(9999999);

    }
    @Test
    void findAll() throws SQLException {
        for (int i = 0; i < 5; i++) {
            DBConnection.getConnection().createStatement().executeUpdate("INSERT into clients(name, address, email, tel) values ('sdfd','fadf','email"+i+"','adfdf')");
        }
        ArrayList<Client> clients = ClientDAO.findAll();
        System.out.println(clients);
        assertEquals(clients.size(),5);
        for (int i = 0; i < 5; i++) {
            ClientDAO.delete("email"+i);
        }

    }
}