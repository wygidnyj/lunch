package complex.objects;

/**
 * An object complex.objects.Ingredient is basic of complex.objects.Dish
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

    private double weight;

    public Ingredient() {
    }

    /**
     * Constructor
     *
     * @param ingredientName  name of ingredient
     * @param ingredientPrice price of ingredient
     */

    public Ingredient(String ingredientName, double ingredientPrice) {
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return ingredientName+" "+ingredientPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;

        Ingredient that = (Ingredient) o;

        return Double.compare(that.ingredientPrice, ingredientPrice) == 0
                && !(ingredientName != null
                ? !ingredientName.equals(that.ingredientName) : that.ingredientName != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ingredientName != null ? ingredientName.hashCode() : 0;
        temp = Double.doubleToLongBits(ingredientPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(double ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }
}

