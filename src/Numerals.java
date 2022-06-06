public class Numerals extends Calculator{

    public Numerals(String value, String unit) {
        super(value, unit);
    }

    //This method checks users input and call required enum constant
    @Override
    public String defineMethod() {

        return unit.equalsIgnoreCase("BINARY") || unit.equalsIgnoreCase("BI") || unit.equals("2")
                ? Numeral.BINARY.convert(value)
                : unit.equalsIgnoreCase("HEXADECIMAL") || unit.equalsIgnoreCase("HEX") || unit.equals("16")
                ? Numeral.HEX.convert(value)
                : value;
    }

    public enum Numeral implements Converter, Data{

        BINARY() {
            //This method converts received value String parameter into binary code value
            @Override
            public String convert(String value) {
                return Integer.toBinaryString(Integer.parseInt(value));
            }
        },
        HEX() {
            //This method converts received value String parameter into hexadecimal code value
            @Override
            public String convert(String value) {
                return Integer.toHexString(Integer.parseInt(value));
            }
        },

    }

}
