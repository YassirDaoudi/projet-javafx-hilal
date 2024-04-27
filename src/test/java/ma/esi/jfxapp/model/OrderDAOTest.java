package ma.esi.jfxapp.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
    @Test
    void save() {
        Order order = new Order(1, 6, 5, 14);
        assertTrue(OrderDAO.save(order));
        OrderDAO.delete(1); // doesnt work cuz id is auto generated in db
    }

    @Test
    void delete() throws SQLException {
        DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO orders(id,product_id, qte, id_client) VALUES (999,6, 5, 14)");
        assertTrue(OrderDAO.delete(999));

    }


    @Test
    void findByClientId() throws SQLException {

        DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO orders(id,product_id, qte, id_client) VALUES (999,6, 5, 14)");
        ArrayList<Order> orders = OrderDAO.findByClientId(14);
        assertFalse(orders.isEmpty());
        assertEquals(orders.get(0).getClientId(), 14);
        System.out.println(orders);
        OrderDAO.delete(999);
    }

    @Test
    void findAll() {
        try {
            for (int i = 0; i < 5; i++) {
                DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO orders(id,product_id, qte, id_client) VALUES ("+(999+i)+",6, 5, 14)");
            }
            ArrayList<Order> orders = OrderDAO.findAll();
            assertEquals(orders.size(), 5);
            for (int i = 0; i < 5; i++) {
                OrderDAO.delete(999+i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}