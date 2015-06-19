package complex;

import java.io.Serializable;

/**
 * An object complex.Ingredient is basic of complex.Dish
 * contain name and price
 *
 * @author Arthur M
 * @since 1.0
 */
public class Ingredient{

    /**
     * Name of ingredient
     */
    private String ingredientName;
    /**
     * Price of ingredient
     */
    private double ingredientPrice;

    /**
     * Constructor
     *
     * @param ingredientName  name of ingredient
     * @param ingredientPrice price of ingredient
     */
    Ingredient(String ingredientName, double ingredientPrice) {
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    /**
     * Returns the name of this product.
     *
     * @return the name of this product
     */
    public String getName() {
        return ingredientName;
    }

    /**
     * Sets the name of ingredient.
     *
     * @param ingredientName set name of this ingredient
     */
    public void setName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    /**
     * Returns the price of this product.
     *
     * @return the price of this product
     */
    public double getPrice() {
        return ingredientPrice;
    }

    /**
     * Sets the price of ingredient.
     *
     * @param ingredientPrice set price of this ingredient
     */
    public void setPrice(double ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }

    @Override
    public String toString() {
        return ingredientName+" "+ingredientPrice;
    }
}
