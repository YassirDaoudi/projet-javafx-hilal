package ma.esi.jfxapp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import ma.esi.jfxapp.model.*;
import org.apache.commons.text.WordUtils;

import java.lang.reflect.Field;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    private TableView Table;

    @FXML
    private VBox detailsVBox;


    @FXML
    public void OnInvoicesClicked() {
        try {
            ObservableList<Invoice> list = FXCollections.observableArrayList(new InvoiceDAO().findAll());
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
            ObservableList<Courier> list = FXCollections.observableArrayList(new CourierDAO().findAll());
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
            ObservableList<Product> list = FXCollections.observableArrayList(new ProductDAO().findAll());
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
            ObservableList<Delivery> list = FXCollections.observableArrayList(new DeliveryDAO().findAll());
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
            ObservableList<Client> list = FXCollections.observableArrayList(new ClientDAO().findAll());

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
    @FXML
    public void onTableClicked(){
        Object o = Table.getSelectionModel().getSelectedItem();
        try {
            generateDetailsView(o);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private <T> void generateDetailsView(T o) throws Exception {
        Field[] fields = o.getClass().getDeclaredFields();
        ArrayList<InputControl<?>> controls = new ArrayList<>();

        for (Field field : fields) {
            HBox container = new HBox();
            container.setAlignment(Pos.CENTER_LEFT);
            container.setPadding(new Insets(0,10,0,10));


            //create label
            Label label = new Label(WordUtils.capitalize(field.getName()));
            label.setAlignment(Pos.CENTER_LEFT);
            label.setPrefWidth(50);
            HBox.setHgrow(label, Priority.ALWAYS);

            //create input field
            InputControl<?> inputControl = DetailsSectionControlsFactory.getInputControl(field);


            HBox.setHgrow(inputControl.getInputField(),Priority.ALWAYS);

            //add them to the hbox
            container.getChildren().addAll(label,inputControl.getInputField());

            //add hbox to the parent vbox
            detailsVBox.getChildren().add(container);

            //add the input field to the controls list
            controls.add(inputControl);

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OnClickClients();
    }
}
