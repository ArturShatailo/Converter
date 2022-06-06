public class Currencies extends Calculator {

    public Currencies(String value, String unit) {
        super(value, unit);
    }

    //This method checks users input and call required enum constant
    @Override
    public String defineMethod(){
        return unit.equalsIgnoreCase("USD") || unit.equalsIgnoreCase("dollar")
                ? Currency.USD.convert(value)
                : unit.equalsIgnoreCase("EUR") || unit.equalsIgnoreCase("euro")
                ? Currency.EUR.convert(value)
                : value;
    }

    public enum Currency implements Converter, Data{

        USD() {
            //This method converts received amount of UAH in String value parameter into USD according to current rate in Data interface
            @Override
            public String convert(String value) {
                return String.valueOf(Tech.roundMet(Double.parseDouble(value) / currentUSDrate));
            }
        },
        EUR() {
            //This method converts received amount of UAH in String value parameter into EUR according to current rate in Data interface
            @Override
            public String convert(String value) {
                return String.valueOf(Tech.roundMet(Double.parseDouble(value) / currentEURrate));
            }
        },

    }

}