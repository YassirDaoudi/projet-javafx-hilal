package ma.esi.jfxapp.model;

import java.util.Objects;

public enum CourierStatus {
    FREE("free") ,
    BUSY("busy");

    final String value;
    CourierStatus(String value){
        this.value=value;
    }

    public static CourierStatus getByValue(String value) {
        if (value.equals("free")) return FREE;
        else if (value.equals("busy")) return BUSY;
        else throw new RuntimeException("No value "+value+"in Enum CourierStatus");
    }
}
