package ma.esi.jfxapp.model;

public enum DeliveryType {
    HOME("home"),
    PICKUP("pickup");

    final String value ;
    DeliveryType(String value){
        this.value = value;
    }
}
