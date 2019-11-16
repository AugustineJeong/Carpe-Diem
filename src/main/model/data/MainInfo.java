package model.data;

public class MainInfo {
    private Double temp;

    public String getTempInCelsius() {
        Double celsius = (temp - 273.15);
        String celsiusString = celsius.toString();
        celsiusString = celsiusString.substring(0, 4);

        return celsiusString;
    }
}
