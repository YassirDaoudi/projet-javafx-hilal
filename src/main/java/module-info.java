module ma.esi.jfxapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.postgresql.jdbc;
    requires org.controlsfx.controls;
    requires java.sql;
    requires org.apache.commons.text;

    opens ma.esi.jfxapp to javafx.fxml;
    opens ma.esi.jfxapp.controllers to  javafx.fxml;
    opens ma.esi.jfxapp.model to javafx.base;
    exports ma.esi.jfxapp;
    exports ma.esi.jfxapp.controllers;
}