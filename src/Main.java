public class Main {

    public static void main(String[] args) {

        System.out.println("Choose what do you wish to convert from menu: ");

        //Call menu method to display UI
        callMenu();
    }

    //THis method creates new Menu object and fills it with required options to choose.
    private static void callMenu() {

        Menu main = new Menu();

        //Filling arrayList for menu creating
        main.arrayMenu.add("CURRENCIES (UAH to EUR or USD)");
        main.arrayMenu.add("TEMPERATURES (calcium to K or F)");
        main.arrayMenu.add("NUMERAL SYSTEMS (dec to binary or hex)");
        main.arrayMenu.add("SYMBOLS (symbols to UNICODE or numeric value)");

        //Menu builder method calling
        main.menuBuilder();

        //Catching of customer's choice into next method with logic for each option
        findCalculator(Tech.GetInputFunction());
    }


    //Depending on user's choice, the method will define what the object to create. The created object will call defineMethod() method
    //override in enums in each class available to create objects here.
    private static void findCalculator(int i) {

        System.out.println("Input value: ");
        String value = Tech.GetInputStringFunction();
        System.out.println("Input unit to convert into: ");
        String unit = Tech.GetInputStringFunction();

        if(i==1){
            System.out.println(new Currencies(value, unit).defineMethod());
        }else if(i==2){
            System.out.println(new Temperatures(value, unit).defineMethod());
        }else if(i==3) {
            System.out.println(new Numerals(value, unit).defineMethod());
        }else if(i==4) {
            System.out.println(new Symbols(value, unit).defineMethod());
        }else{
            System.out.println("There is no such number");
            callMenu();
        }
        callMenu();
    }

}
