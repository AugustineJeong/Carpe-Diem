package model.data;

public class MainInfo {
    private Double temp;

    //EFFECTS: converts and returns temp field from kelvin to celsius degrees
    public String getTempInCelsius() {
        Double celsius = (temp - 273.15);
        String celsiusString = celsius.toString();
        celsiusString = celsiusString.substring(0, 4);

        return celsiusString;
    }
}
