package ma.esi.jfxapp.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
    @Test
    void save() throws SQLException {
        Order order = new Order(1, 6, 5,10.,10);
        assertTrue(new OrderDAO().save(order));
        new OrderDAO().delete(1); // doesnt work cuz id is auto generated in db
    }

    @Test
    void delete() throws SQLException {
        DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO orders(id,product_id, qte) VALUES (999,6, 5)");
        assertTrue(new OrderDAO().delete(999));

    }



    @Test
    void findAll() {
        try {
            for (int i = 0; i < 5; i++) {
                DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO orders(id,product_id, qte) VALUES ("+(999+i)+",6, 5)");
            }
            ArrayList<Order> orders = new OrderDAO().findAll();
            assertEquals(orders.size(), 5);
            for (int i = 0; i < 5; i++) {
                new OrderDAO().delete(999+i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void name() throws SQLException {



    }
}