package complex;

/**
 * An object last is launcher
 * contain main method
 *
 * @author Andrii V
 * @author Arthur M
 * @see Menu
 * @since 1.0
 */
public class Main {
       /**
     * main method
     */
    public static void main(String[] args) {
        String stringFirst = "First dish: ";
        String stringSecond = "Second dish: ";
        String stringDrink = "Drinks: ";
        String stringTotalPrice = "Total price: ";
        String stringComplex = "Proposition for you : ";

        double money = 50;

        Menu menu = new Menu();
        menu.fillDishList();

        System.out.println(stringFirst);
        for (Dish d: menu.getDishByCategory(DishCategory.FIRST)){
            System.out.print(d.getDishName());
            System.out.println(d.getDishPrice());
        }
        System.out.println();

        System.out.println(stringSecond);
        for (Dish d: menu.getDishByCategory(DishCategory.SECOND)){
            System.out.print(d.getDishName());
            System.out.println(d.getDishPrice());
        }
        System.out.println();

        System.out.println(stringDrink);
        for (Dish d: menu.getDishByCategory(DishCategory.DRINK)){
            System.out.print(d.getDishName());
            System.out.println(d.getDishPrice());
        }
        System.out.println();

        System.out.println(stringComplex);
        for (Complex c: menu.getComplexByPrice(money)){

            System.out.println(c.getFirst().getDishName()
                    +" "+c.getSecond().getDishName()
                    +" "+c.getDrink().getDishName()
                    +" "+stringTotalPrice+c.getPriceOfComplex()
            );

        }





    }

}
