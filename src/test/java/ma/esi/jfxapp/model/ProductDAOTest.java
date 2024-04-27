package ma.esi.jfxapp.model;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOTest {

    @Test
    void save() {
        Product product = new Product(1, "Product A", 10);
        assertTrue(ProductDAO.save(product));
    }
    @Test
    void deleteId() {
        try {
            DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO products VALUES (99999, 'ProductToDelete', 10)");
            assertTrue(ProductDAO.delete(99999));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteLabel() {
        try {
            DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO products VALUES (99999, 'ProductToDelete', 10)");
            assertTrue(ProductDAO.delete("ProductToDelete"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    void find() throws SQLException {
        DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO products VALUES (9999999, 'Product A', 10)");
        Product product = new Product(9999999, "Product A", 10);
        Product productFound = ProductDAO.find(product.getLabel()).get(0);
        assertEquals(productFound.getId(), product.getId());
        assertEquals(productFound.getLabel(), product.getLabel());
        assertEquals(productFound.getQuantityInStock(), product.getQuantityInStock());
        assertTrue(ProductDAO.find("").isEmpty());
        ProductDAO.delete(9999999);
    }

    @Test
    void findAll() throws SQLException {
        for (int i = 0; i < 5; i++) {
            DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO products VALUES (DEFAULT, 'Product"+i+"', 10)");
        }
        ArrayList<Product> products = ProductDAO.findAll();
        assertEquals(products.size(), 5);
        for (int i = 0; i < 5; i++) {
            ProductDAO.delete("Product"+i);
        }
    }


}