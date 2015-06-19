package complex;

import java.util.ArrayList;
import java.util.List;

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
        String firstCategory = "First dish: ";
        String secondCategory = "Second dish: ";
        String drinkCategory = "Drinks: ";
        String proposition = "Proposition for you : ";
        String fileName = "dishes.json";

        double money = 500;

        Menu menu = new Menu();
        menu.fillDishList();

        System.out.println(firstCategory);
        for (Dish d : menu.getDishByCategory(DishCategory.FIRST)) {

            System.out.println(d);

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
        for (Complex c : menu.getComplexByPrice(money)) {

            System.out.println(c);

        }

        JsonHelper jsonHelper= new JsonHelper();

        jsonHelper.writeToFile(fileName,menu.getAllDishes());

        List<Dish> dishesFromFile;
        dishesFromFile = jsonHelper.readFromFile(fileName);

        System.out.println("From file; ");
        for (Dish dish:dishesFromFile){
            System.out.println(dish);
        }


    }

}
