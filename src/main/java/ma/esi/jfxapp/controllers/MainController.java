package ma.esi.jfxapp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.esi.jfxapp.model.*;
import org.apache.commons.lang3.text.WordUtils;

import java.lang.reflect.Field;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    private TableView Table;

    @FXML
    private Label clientsNav;
    @FXML
    private Label productsNav;
    @FXML
    private Label invoicesNav;
    @FXML
    private Label couriersNav;
    @FXML
    private Label deliveriesNav;


    @FXML
    public void OnInvoicesClicked() {
        try {
            ObservableList<Invoice> list = FXCollections.observableArrayList(InvoiceDAO.findAll());
            if (!list.isEmpty()) setTableColumns(Table,list);
            else setTableColumns(Table,Invoice.class.getDeclaredFields());
//            Table.refresh();

        } catch (SQLException ex) {
            //i gotta do some more error handling heree
            ex.printStackTrace();
        }
    }
    @FXML
    public void OnCouriersClicked() {
        try {
            ObservableList<Courier> list = FXCollections.observableArrayList(CourierDAO.findAll());
            if (!list.isEmpty()) setTableColumns(Table,list);
            else setTableColumns(Table,Courier.class.getDeclaredFields());
//            Table.refresh();

        } catch (SQLException ex) {
            //i gotta do some more error handling heree
            ex.printStackTrace();
        }
    }
    @FXML
    public void OnProductsClicked() {
        try {
            ObservableList<Product> list = FXCollections.observableArrayList(ProductDAO.findAll());
            if (!list.isEmpty()) setTableColumns(Table,list);
            else setTableColumns(Table,Product.class.getDeclaredFields());

        } catch (SQLException ex) {
            //i gotta do some more error handling heree
            ex.printStackTrace();
        }
    }
    @FXML
    public void OnDeliveriesClicked() {
        try {
            ObservableList<Delivery> list = FXCollections.observableArrayList(DeliveryDAO.findAll());
            if (!list.isEmpty()) setTableColumns(Table,list);
            else setTableColumns(Table,Delivery.class.getDeclaredFields());
//            Table.refresh();

        } catch (SQLException ex) {
            //i gotta do some more error handling heree
            ex.printStackTrace();
        }
    }



    @FXML
    public void OnClickClients() {
        try {
            ObservableList<Client> list = FXCollections.observableArrayList(ClientDAO.findAll());

            if (!list.isEmpty()) setTableColumns(Table,list);
            else setTableColumns(Table,Client.class.getDeclaredFields());
//            Table.refresh();

        } catch (SQLException ex) {
            //i gotta do some more error handling heree
            ex.printStackTrace();
        }

    }


    private <T> void setTableColumns(TableView<T> table, ObservableList<T> items){
        table.setItems(items);
        Field[] fields = items.get(0).getClass().getDeclaredFields();
        ArrayList<TableColumn<T,?>> cols= new ArrayList<>();
        for (Field f: fields) {
            TableColumn<T, Integer> col = new TableColumn<>(WordUtils.capitalize(f.getName()));
            col.setCellValueFactory(new PropertyValueFactory<>(f.getName()));
            cols.add(col);
        }
        table.getColumns().setAll(cols);
    }
    private <T> void setTableColumns(TableView<T> table, Field[] fields){
        ArrayList<TableColumn<T,?>> cols= new ArrayList<>();
        for (Field f: fields) {
            TableColumn<T, Integer> col = new TableColumn<>(WordUtils.capitalize(f.getName()).trim());
            col.setCellValueFactory(new PropertyValueFactory<>(f.getName()));
            cols.add(col);

        }
        table.getColumns().setAll(cols);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OnClickClients();
    }
}
