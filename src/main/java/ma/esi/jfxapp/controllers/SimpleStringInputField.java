package ma.esi.jfxapp.controllers;

import javafx.scene.control.TextField;

import java.lang.reflect.Field;

public class SimpleStringInputField implements InputControl<String>{
    private final Field correspondingField;
    private final TextField inputField;

    public SimpleStringInputField(Field correspondingField) {
        inputField = new TextField();
        this.correspondingField = correspondingField;
    }

    public TextField getInputField() {
        return inputField;
    }


    @Override
    public Field getCorrespondingField() {
        return correspondingField;
    }

    @Override
    public String getValue() {
        return inputField.getText();
    }

    @Override
    public void setValue(String value) {
        inputField.setText(value);
    }
}
