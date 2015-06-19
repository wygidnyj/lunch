package complex.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * An object complex.objects.Dish contain name  price and category
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
    private double dishPrice;
    /**
     * Category of dish
     */
    private DishCategory dishCategory;

    /**
     * Map of ingredient and ingredientWeight
     */
    private List<Ingredient> ingredients = new ArrayList<>();

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
        double newIngredientPrice = ingredient.getPrice() * weight;
        if (ingredients.contains(ingredient)) {
            int index = ingredients.indexOf(ingredient);
            double oldPrice = ingredients.get(index).getPrice();
            ingredients.get(index).setPrice(oldPrice + newIngredientPrice);

        } else {
            ingredients.add(ingredient);

        }
        dishPrice += newIngredientPrice;

    }

    @Override
    public String toString() {
        return dishName + " " + dishPrice;
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