package complex;

import complex.objects.*;
import complex.utils.DishDAOtoDB;

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


        DishDAOtoDB dishDAOtoDB = new DishDAOtoDB();

        Ingredient beet = new Ingredient("beet", 1);
        beet.setWeight(1);
        Ingredient potatos = new Ingredient("potatoes", 1);
        potatos.setWeight(1);
        Ingredient meet = new Ingredient("meat", 1);
        meet.setWeight(1);
        Ingredient onion = new Ingredient("onion", 1);
        onion.setWeight(1);

        Dish borsh = new Dish("Борщ", DishCategory.FIRST);
        borsh.addToDish(beet, 1.0);
        borsh.addToDish(potatos, 1.0);
        borsh.addToDish(meet, 1.0);
        borsh.addToDish(onion, 1.0);

        Dish boulion = new Dish("Бульйон", DishCategory.FIRST);
        boulion.addToDish(meet, 1.0);
        boulion.addToDish(onion, 1.0);
        boulion.addToDish(potatos, 1.0);

        DishDAOtoDB db = new DishDAOtoDB();
        db.addDish(borsh);
        db.addDish(borsh);
        db.addDish(boulion);
        System.out.println(borsh);
        System.out.println(boulion);

        for (Dish d:db.getAllDishes()){
            System.out.println(d);

        }



    }


}
