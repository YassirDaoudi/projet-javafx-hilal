package ma.esi.jfxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InventoryManagerApplication extends Application {
    private static Stage stage ;
    @Override
    public void start(Stage stage) throws IOException {
        InventoryManagerApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(InventoryManagerApplication.class.getResource("authentication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }
}