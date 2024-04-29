package ma.esi.jfxapp.model;

import java.util.Objects;

public enum CourierStatus {
    FREE("free") ,
    BUSY("busy");

    final String value;
    CourierStatus(String value){
        this.value=value;
    }

}
