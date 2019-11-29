package model.data;

public class MainInfo {
    private Double temp;

    //EFFECTS: converts temp field from kelvin to celsius degrees and returns as a string
    public String getTempInCelsius() {
        Double celsius = (temp - 273.15);
        String celsiusString = celsius.toString();
        celsiusString = celsiusString.substring(0, 4);

        return celsiusString;
    }
}
