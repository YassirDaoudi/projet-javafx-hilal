package ma.esi.jfxapp.controllers;

import ma.esi.jfxapp.model.Delivery;
import ma.esi.jfxapp.model.DeliveryType;
import ma.esi.jfxapp.model.Invoice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DropDownListTest {

    @Test
    void getInputField() throws NoSuchFieldException {
        DropDownList<DeliveryType> d = new DropDownList<>(Invoice.class.getDeclaredField("deliveryType"),DeliveryType.class);
        d.getInputField();
    }

    @Test
    void getCorrespondingField() {
    }

    @Test
    void getValue() {
    }
}