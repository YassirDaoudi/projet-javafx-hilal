package ma.esi.jfxapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthenticationController {

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;
    @FXML
    private Label wrongCredsMessage;

//    @FXML
//    protected void login(){
//            wrongCredsMessage.setManaged(false);
//            wrongCredsMessage.setVisible(false);
//        try {
//            ArrayList<User> matches = UserDAO.findByEmailAndPassword(emailField.getText(),passwordField.getText());
//            if (matches.isEmpty()) {
//                throw new Exception("login or passowd bad");
//            }
//        }catch (Exception ex){
//            wrongCredsMessage.setManaged(true);
//            wrongCredsMessage.setVisible(true);
//        }
//    }
//    @FXML
//    protected void onRegisterButtonClick() {
//        FXMLLoader loader = new FXMLLoader(InventoryManagerApplication.class.getResource("register.fxml"));
//        try {
//            Parent parent = loader.load();
//            Scene scene = new Scene(parent);
//            InventoryManagerApplication.getStage().setScene(scene);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}