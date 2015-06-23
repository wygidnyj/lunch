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
    public int getNumberOfIngredients(){
        return ingredients.size();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;

        Dish dish = (Dish) o;

        boolean equalsName = dishName.equals(((Dish) o).dishName);
        boolean equalsPrice = dishPrice == ((Dish) o).dishPrice;
        boolean equalsCategory = dishCategory.equals(((Dish) o).dishCategory);
        return equalsName && equalsPrice && equalsCategory;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dishName.hashCode();
        temp = Double.doubleToLongBits(getDishPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getDishCategory().hashCode();
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        return result;
    }
}