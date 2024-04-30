package ma.esi.jfxapp.model;

import java.util.Objects;

public enum DeliveryType {
    HOME("home"),
    PICKUP("pickup");

    final String value ;
    DeliveryType(String value){
        this.value = value;
    }

    public static DeliveryType getByString(String value) {
        if (Objects.equals(value, "home")) return DeliveryType.HOME;
        else if (value.equals("pickup")) return DeliveryType.PICKUP;
        else throw new RuntimeException("No value "+value+"in Enum DeliveryType");
    }
}
