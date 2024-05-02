package ma.esi.jfxapp.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class InvoiceDAOTest {

    @Test
    void getOrders() throws SQLException {
        for (int i = 0; i <5; i++) {
            new OrderDAO().save(new Order(0,6,80,1));
        }
        System.out.println(new InvoiceDAO().getOrders(1));

    }

    @Test
    void getDelivery() {

    }
}