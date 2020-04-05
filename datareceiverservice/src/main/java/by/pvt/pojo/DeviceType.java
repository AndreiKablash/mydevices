package by.pvt.pojo;

public enum DeviceType {
    KETTLE("Kettle"),
    TV("TV"),
    COOKER("Cooker"),
    WASHING("Washing-machine"),
    FRIDGE("Refrigerator"),
    AIRCON("Airconditioner"),
    CLEANER("Vacuum cleaner"),
    COFFEE("Coffee Machine");

    private String description;

    DeviceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
