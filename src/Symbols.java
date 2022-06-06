public class Symbols extends Calculator{

    public Symbols(String value, String unit) {
        super(value, unit);
    }

    //This method checks users input and call required enum constant
    @Override
    public String defineMethod() {

        return unit.equalsIgnoreCase("UNICODE") || unit.equalsIgnoreCase("UNI") || unit.equalsIgnoreCase("UTF")
                ? Symbol.UNICODE.convert(value)
                : unit.equalsIgnoreCase("NUMERIC VALUE") || unit.equalsIgnoreCase("NUMERIC") || unit.equalsIgnoreCase("NUM")
                ? Symbol.NUM.convert(value)
                : value;

    }

    //Enum class with 2 constants and override methods into them, implemented from Converter.
    public enum Symbol implements Converter, Data{

        UNICODE() {
            //Method gets String, convert it into char array and then convert each char into UNICODE code.
            @Override
            public String convert(String value) {

                StringBuilder a = new StringBuilder();
                for (char c : value.toCharArray()) {
                    a.append(c)
                            .append(": \\u")
                            .append(Integer.toHexString(c | 0x10000).substring(1))
                            .append(", ");
                }
                return String.valueOf(a);
            }
        },

        NUM() {
            //Method gets String, convert it into char array and then convert each char into NUMERIC value.
            @Override
            public String convert(String value) {

                StringBuilder a = new StringBuilder();
                for (char c : value.toCharArray()) {
                    a.append(c)
                            .append(": ")
                            .append(Character.getNumericValue(c))
                            .append(", ");
                }
                return String.valueOf(a);
            }
        },

    }

}
