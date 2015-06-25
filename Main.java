package complex;

import complex.objects.*;
import complex.utils.DishDAOtoDB;
import complex.utils.IngredientDAOtoDB;
import complex.utils.MainDB;
import complex.utils.MetaWriter;

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
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        menu.fillDishList();

        dishWriteReadtoDDB();


    }

    private static void doMenuMethods(Menu menu, double money) {
        String firstCategory = "First dish: ";
        String secondCategory = "Second dish: ";
        String drinkCategory = "Drinks: ";
        String proposition = "Proposition for you : ";


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

    }




    private static void dishWriteReadtoDDB() {
        int idOfDish = 0;
        int idOfIngredient = 0;

        DishDAOtoDB dishDAOtoDB = new DishDAOtoDB();

        Ingredient beet = new Ingredient("beet", 13.40, idOfIngredient++);
        beet.setWeight(0.5);
        Ingredient potatos = new Ingredient("potatoes", 12.00, idOfIngredient++);
        potatos.setWeight(1.0);
        Ingredient meet = new Ingredient("meat", 40.0, idOfIngredient++);
        meet.setWeight(2);
        Ingredient onion = new Ingredient("onion", 10, idOfIngredient++);
        onion.setWeight(0.2);

        Dish borsh = new Dish("Борщ", DishCategory.FIRST);
        borsh.addToDish(beet, 5.0);
        borsh.addToDish(potatos, 1.0);
        borsh.addToDish(meet, 5.0);
        borsh.addToDish(onion, 0.5);
        borsh.setIdOfDish(++idOfDish);

        MainDB db = new MainDB();
        db.saveDish(borsh);

    }


}
