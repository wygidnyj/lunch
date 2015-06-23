package complex;

import complex.objects.Complex;
import complex.objects.Dish;
import complex.objects.DishCategory;
import complex.objects.Menu;
import complex.utils.JsonHelper;

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
    public static void main(String[] args) throws Exception {
        String firstCategory = "First dish: ";
        String secondCategory = "Second dish: ";
        String drinkCategory = "Drinks: ";
        String proposition = "Proposition for you : ";
        String fileName = "menu.json";
        String fromFile = "From file:  ";

        double money = 500;

        Menu menu = new Menu();
        menu.fillDishList();

        System.out.println(firstCategory);
        for (Dish dish : menu.getDishByCategory(DishCategory.FIRST)) {

            System.out.println(dish);
        }
        System.out.println();

        System.out.println(secondCategory);
        for (Dish dish : menu.getDishByCategory(DishCategory.SECOND)) {

            System.out.println(dish);
        }
        System.out.println();

        System.out.println(drinkCategory);
        for (Dish dish : menu.getDishByCategory(DishCategory.DRINK)) {

            System.out.println(dish);
        }
        System.out.println();

        System.out.println(proposition);
        for (Complex complex : menu.getComplexByPrice(money)) {

            System.out.println(complex);

        }
        System.out.println();

        JsonHelper.writeToJson(fileName, menu);

        Menu menuFromFile = JsonHelper.readFromJson(fileName);

        System.out.println(fromFile);
        for (Dish dish : menuFromFile.getAllDishes()) {
            System.out.println(dish);

        }


    }


}
