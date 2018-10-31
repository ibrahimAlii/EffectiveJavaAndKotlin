package Item02.java.sample2;

import static Item02.java.sample2.NyPizza.Size.SMALL;

public class Usage {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION).build();

        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();

    }
}
