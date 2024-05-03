package ma.esi.jfxapp.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientDAOTest {

    @Test
    void save() {
        Client client = new Client(1,"Mr client","Nowhere Street","client@client.com","0522539236");
        assertTrue(new ClientDAO().save(client));
        new ClientDAO().delete("client@client.com");

    }

    @Test
    void deleteId() {

        try {
            DBConnection.getConnection().createStatement().executeUpdate("INSERT into clients values (99999,'sdfd','fadf','adfaf','adfdf')");
            assertTrue(new ClientDAO().delete(99999));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void deleteEmail() {
        try {
            DBConnection.getConnection().createStatement().executeUpdate("INSERT into clients(name, address, email, tel) values ('sdfd','fadf','email','adfdf')");
            assertTrue(new ClientDAO().delete("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void find() throws SQLException {
        DBConnection.getConnection().createStatement().executeUpdate("INSERT into clients(id,name, address, email, tel) values (9999999,'sdfd','fadf','email','adfdf')");
        Client client = new Client(9999999,"sdfd","fadf","email","adfdf");
        Client client1 = new ClientDAO().find(client.getEmail()).get(0);
        assertEquals(client1, client);
        assertTrue(new ClientDAO().find("").isEmpty());
        new ClientDAO().delete(9999999);

    }
    @Test
    void findAll() throws SQLException {
        for (int i = 0; i < 5; i++) {
            DBConnection.getConnection().createStatement().executeUpdate("INSERT into clients(name, address, email, tel) values ('sdfd','fadf','email"+i+"','adfdf')");
        }
        ArrayList<Client> clients = new ClientDAO().findAll();
        System.out.println(clients);
        assertEquals(clients.size(),5);
        for (int i = 0; i < 5; i++) {
            new ClientDAO().delete("email"+i);
        }

    }

    @Test
    void update() throws SQLException {
        new ClientDAO().update(new Client(1,"Client1","nowhere","email@email.com","063632683"));
    }
}