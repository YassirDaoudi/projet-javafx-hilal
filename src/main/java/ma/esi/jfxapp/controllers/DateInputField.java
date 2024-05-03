package ma.esi.jfxapp.controllers;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class DateInputField implements InputControl<Date> {
    private final Field correspondingField;
    private final DatePicker inputField;

    public DateInputField(Field correspondingField) {
        this.correspondingField = correspondingField;
        this.inputField = new DatePicker();
    }

    public DatePicker getInputField() {
        return inputField;
    }

    @Override
    public Field getCorrespondingField() {
        return correspondingField;
    }

    @Override
    public Date getValue() {
        return  new Date(inputField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    @Override
    public void setValue(Date value) {
        inputField.setValue(value.toLocalDate());
    }


}
