package utils;

public enum FuelType {
    GAS("G"),
    ELECTRIC("E"),
    PETROL("P"),
    HYBRID("H"),
    DIESEL("D");

    private String value;

    FuelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
