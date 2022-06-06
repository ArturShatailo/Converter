public class Temperatures extends Calculator{

    public Temperatures(String value, String unit) {
        super(value, unit);
    }

    //This method checks users input and call required enum constant
    @Override
    public String defineMethod() {

        return unit.equalsIgnoreCase("Kelvin") || unit.equalsIgnoreCase("K")
                ? Temperature.K.convert(value)
                : unit.equalsIgnoreCase("Fahrenheit") || unit.equalsIgnoreCase("F")
                ? Temperature.F.convert(value)
                : value;
    }

    public enum Temperature implements Converter, Data{

        K() {
            //This method converts received String value of temperature in Celsius into Kelvin value
            @Override
            public String convert(String value) {
                return String.valueOf(Tech.roundMet(Double.parseDouble(value) + kelvin));
            }
        },
        F() {
            //This method converts received String value of temperature in Celsius into Fahrenheit value
            @Override
            public String convert(String value) {
                return String.valueOf(Tech.roundMet((Double.parseDouble(value) * fahrenheit1) + fahrenheit2));
            }
        },

    }

}
