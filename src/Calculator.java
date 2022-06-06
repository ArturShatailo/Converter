public class Calculator{

    protected String value;
    protected String unit;

    public Calculator(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public String defineMethod(){
        return value;
    }

}
