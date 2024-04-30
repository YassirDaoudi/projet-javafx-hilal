package ma.esi.jfxapp.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceDAOTest {

    @Test
    void getOrders() throws SQLException {
        for (int i = 0; i <5; i++) {
            OrderDAO.save(new Order(0,6,80,1));
        }
        System.out.println(InvoiceDAO.getOrders(1));

    }

    @Test
    void getDelivery() {

    }
}