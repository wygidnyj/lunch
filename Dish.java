package complex;

import java.util.*;

/**
 * An object complex.Dish contain name  price and category
 *
 * @author Arthur M
 * @see Map
 * @see Double
 * @see DishCategory
 * @since 1.0
 */

public class Dish {

    /**
     * Name of dish
     */
    private String dishName;
    /**
     * Price of dish
     */
    private Double dishPrice =0.0;
    /**
     * Category of dish
     */
    private DishCategory dishCategory;
    //map <ingredient, ingredientWeight>
    /**
     * Map of ingredient and ingredientWeight
     */
    private Map<Ingredient, Double> ingredients = new HashMap<>();

    /**
     * Constructor
     *
     * @param nameOfDish name of dish
     * @param category   category of dish
     */
    public Dish(String nameOfDish, DishCategory category) {
        dishName = nameOfDish;
        dishCategory = category;
    }

    /**
     * Returns the name of this dish.
     *
     * @return the name of this dish
     */
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String nameOfDish) {
        this.dishName = nameOfDish;
    }

    /**
     * Returns the price of this dish.
     *
     * @return the price of this dish
     */
    public double getDishPrice() {
        return dishPrice;
    }

    /**
     * Add ingredients to dish and calculus price.
     *
     * @param ingredient add  new ingredient
     * @param weight     weight of ingredient
     */
    public void addToDish(Ingredient ingredient, Double weight) {
        boolean contain = false;
        if(ingredients.isEmpty()){

           // contain = false;

        } else {
            for(Ingredient z:ingredients.keySet()) {
                if (z.getName().toLowerCase().equals(ingredient.getName().toLowerCase())) {
                    contain = true;
                    break;
                }
            }

        }


        if (!contain){
            ingredients.put(ingredient, weight);
            dishPrice += ingredient.getPrice()*weight;

        }


    }

    @Override
    public String toString() {
        return dishName+" "+dishPrice;
    }

    public void addOrReplaceToDish(Ingredient ingredient, Double weight){

//TODO
    }

    /**
     * Return category of dish
     *
     * @return dish category
     */
    public DishCategory getDishCategory() {
        return dishCategory;
    }

    /**
     * Set category of this dish.
     *
     * @param dishCategory category of this dish
     */
    public void setDishCategory(DishCategory dishCategory) {
        this.dishCategory = dishCategory;
    }
}