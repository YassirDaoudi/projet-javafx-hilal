package ma.esi.jfxapp.controllers;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import ma.esi.jfxapp.model.DeliveryType;
import ma.esi.jfxapp.model.Invoice;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class DropDownList<T extends Enum<T>> implements InputControl<T>{

    private final Field correspondingField;


    public ComboBox<T> getInputField() {
        return inputField;
    }

    private final ComboBox<T> inputField;

    public DropDownList(Field correspondingField, Class<T> enumeration) {
        this.correspondingField = correspondingField;
        this.inputField = new ComboBox<>(FXCollections.observableArrayList((enumeration.getEnumConstants())));


    }

    @Override
    public Field getCorrespondingField() {
        return correspondingField;
    }

    @Override
    public T getValue() {
        return  inputField.getValue();
    }

    @Override
    public void setValue(T value) {
        inputField.setValue(value);
    }
}
