package by.pvt.pojo;

public enum SensorType {

    OTHER("Common type"),
    TEMP("Temperature sensor"),
    LIGHT("Light sensor"),
    AIR("Air quality sensor"),
    ARRIVAL("Arrival sensor"),
    MOTION("Motion sensor");


    private String description;

    SensorType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
