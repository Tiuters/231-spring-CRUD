package web.model;

public class Car {
    private String name;
    private String type;
    private int wheels;

    public Car(String name, String type, int wheels) {
        this.name = name;
        this.type = type;
        this.wheels = wheels;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWheels() {
        return wheels;
    }
}
