package ma.esi.jfxapp.model;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CourierDAOTest {

    @Test
    void save() throws SQLException {
        Courier c  = new Courier(8,"mhmd",CourierStatus.FREE);
        CourierDAO.save(c);
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery("Select * from couriers where name='"+c.getName()+"'");
        rs.next();
        assertEquals(rs.getString(2),c.getName());
        DBConnection.getConnection().createStatement().executeUpdate("DELETE from couriers where id = "+rs.getInt(1));
    }

    @Test
    void delete() throws SQLException {

        DBConnection.getConnection().createStatement().executeUpdate("INSERT INTO couriers(ID, NAME, STATUS) VALUES (999,'DFSF','free')");
        DBConnection.getConnection().createStatement().executeUpdate("DELETE from couriers where id = 999");
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery("Select * from couriers where id= 999");
        assertFalse(rs.isBeforeFirst());


    }

    @Test
    void findAll() throws SQLException {
    }

    @Test
    void findById() {
    }
}