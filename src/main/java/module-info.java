module ma.esi.jfxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.postgresql.jdbc;
    requires org.controlsfx.controls;
    requires java.sql;

    opens ma.esi.jfxapp to javafx.fxml;
    exports ma.esi.jfxapp;
    exports ma.esi.jfxapp.controllers;
    opens ma.esi.jfxapp.controllers to javafx.fxml;
}