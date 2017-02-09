package Q4;

/**
 * Write this class.
 */
public class Trio implements MenuItem {
    private Sandwich sandwich;
    private Salad salad;
    private Drink drink;

    public Trio(Sandwich s, Salad sal, Drink d) {
        sandwich = s;
        salad = sal;
        drink = d;
    }

    public String getName() {
        return sandwich.getName() + "/" + salad.getName() + "/" + drink.getName() + " Trio";
    }

    public double getPrice() {
        double min = Math.min(sandwich.getPrice(), Math.min(salad.getPrice(), drink.getPrice()));
        return sandwich.getPrice() + salad.getPrice() + drink.getPrice() - min;
    }


    public static void main(String[] args) {
        Sandwich sand1= new Sandwich("Cheeseburger", 2.75);
        Salad salad1 = new Salad("Spinach Salad", 1.25);
        Drink drink1 = new Drink("Orange Soda", 1.25);
        Trio trio1 = new Trio(sand1, salad1, drink1);
        System.out.println(trio1.getName());
        System.out.println(trio1.getPrice());

        Sandwich sand2= new Sandwich("Club Sandwich", 2.75);
        Salad salad2 = new Salad("Coleslaw", 1.25);
        Drink drink2 = new Drink("Cappuccino", 3.50);



        Trio trio2 = new Trio(sand2, salad2, drink2);
        System.out.println(trio2.getName());
        System.out.println(trio2.getPrice());
    }

}
