package ma.esi.jfxapp.controllers;

import javafx.scene.control.Control;

import java.lang.reflect.Field;

public interface InputControl<T> {
    Field getCorrespondingField();
    T getValue();
    void setValue(T value);
    Control getInputField();

}
