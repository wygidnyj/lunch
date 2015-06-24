package complex;

import complex.objects.*;
import complex.utils.DBHelper;
import complex.utils.JsonHelper;

import java.io.IOException;
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

//        double money = 500;
//
        Menu menu = new Menu();
        menu.fillDishList();
//
//        doSomthWithMenu(menu, money);
//
//        doSonthWithJson(menu);
//
        readAndWriteToDB();



    }

    private static void doSomthWithMenu(Menu menu, double money) {
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

    private static void doSonthWithJson(Menu menu) throws IOException {

        String fileName = "menu.json";
        String fromFile = "From file:  ";
        JsonHelper.writeToJson(fileName, menu);

        Menu menuFromFile = JsonHelper.readFromJson(fileName);

        System.out.println(fromFile);
        for (Dish dish : menuFromFile.getAllDishes()) {
            System.out.println(dish);

        }

//        String json = JsonHelper.ingredientListToJson(menu.getAllDishes()
//                .get(0).getIngredients());
//        System.out.println(json);
//        ArrayList ingredientsList = JsonHelper.ingredientListFromJson(json);
//        System.out.println(ingredientsList);
    }

    private static void readAndWriteToDB() {

        Menu menuOut = new Menu(); // Menu for writing to DB
        Menu menuIn; // Menu for reading from DB
        menuOut.fillDishList();
        List<Dish> dishList = menuOut.getAllDishes();

        DBHelper dbHelper = new DBHelper();

        for (Dish j : dishList) {
            dbHelper.addDishToTable(j);
        }

        // read all dishes from out DataBase
        menuIn = dbHelper.readDishesFromTable();
        // show all dishes from menuIn
        dishList = menuIn.getAllDishes();
        for (Dish j1 : dishList) {
            System.out.println(j1.getDishName());
            for (Ingredient i : j1.getIngredients()) {
                System.out.println(i);
            }
        }

    }


}
