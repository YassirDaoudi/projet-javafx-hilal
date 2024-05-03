package ma.esi.jfxapp.controllers;

import ma.esi.jfxapp.model.CourierStatus;
import ma.esi.jfxapp.model.DeliveryType;

import java.lang.reflect.Field;
import java.sql.Date;

public class DetailsSectionControlsFactory {
    public static InputControl<?> getInputControl(Field field) throws Exception {
        if (field.getType().equals(String.class) || field.getType().equals(Integer.class)) {
            return new SimpleStringInputField(field);
        } else if (field.getType().equals(Date.class)) {
            return new DateInputField(field);
        } else if (field.getType().equals(DeliveryType.class)) {
            return new DropDownList<>(field,DeliveryType.class);
        } else if (field.getType().equals(CourierStatus.class)) {
            return new DropDownList<>(field,CourierStatus.class);

        }else{
            throw new Exception("Failed to generate input field for the field type : "+field.getType());
        }
    }
}
