package complex.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * An object complex Menu represent complex in restaurant or cafe.
 * <p/>
 * complex.objects.Menu performing calculations related to complex
 * such as printing and print complex set lunches at the specified price.
 * Contain lists of first, second dish and drinks
 *
 * @author Andrii V <wygidnyj@gmail.com>
 * @see List
 * @see ArrayList
 * @see String
 * @since 1.0
 */

public class Menu {

    /**
     * List of all dishes
     */
    private List<Dish> dishList;

    /**
     * Public constructor
     */
    public Menu() {
        dishList = new ArrayList<>();
    }

    /**
     * Add dish to lists according to category of this dish
     *
     * @param dish dish which you want to add to complex
     */
    public void addDish(Dish dish) {

        dishList.add(dish);
    }

    /**
     * Print all dish from selected category
     *
     * @param category category of dish you want to print list
     */
    public List<Dish> getDishByCategory(DishCategory category) {
        List<Dish> tempList = new ArrayList<>();
        for (Dish d : dishList) {
            if (d.getDishCategory().equals(category)) {
                tempList.add(d);
            }

        }
        return tempList;
    }

    /**
     * Return  all complex
     *
     * @return menu as a list od dish
     */
    public List<Dish> getAllDishes() {
        return dishList;
    }

    /**
     * Return complex of dish by selected price
     *
     * @param money money of cost of lunch
     * @return list of complex dish
     */
    public List<Complex> getComplexByPrice(double money) {

        List<Complex> tempList = new ArrayList<>();
        for (Dish dishFirst : getDishByCategory(DishCategory.FIRST)) {
            for (Dish dishSecond : getDishByCategory(DishCategory.SECOND)) {
                for (Dish drink : getDishByCategory(DishCategory.DRINK)) {
                    double priceOfComplex = dishFirst.getDishPrice() + dishSecond.getDishPrice() + drink.getDishPrice();
                    if (priceOfComplex <= money) {
                        Complex tmpComplex = new Complex(dishFirst, dishSecond, drink);
                        tempList.add(tmpComplex);

                    }
                }
            }
        }

        return tempList;

    }

    /**
     * Fill complex.objects.Menu by some elements
     */
    public void fillDishList() {

        int idOfDish = 0;
        int idOfIngredient = 0;


        Ingredient beet = new Ingredient("beet", 13.40,idOfIngredient++);
        Ingredient potatos = new Ingredient("potatoes", 12.00,idOfIngredient++);
        Ingredient meet = new Ingredient("meat", 40.0,idOfIngredient++);
        Ingredient carrots = new Ingredient("carrots", 18.50,idOfIngredient++);
        Ingredient cabadge = new Ingredient("cabbage", 14.15,idOfIngredient++);
        Ingredient chicken = new Ingredient("chicken", 45.00,idOfIngredient++);
        Ingredient onion = new Ingredient("onion", 10,idOfIngredient++);
        Ingredient vermicelli = new Ingredient("vermicelli", 19.00,idOfIngredient++);

        Dish borsh = new Dish("Борщ", DishCategory.FIRST);
        borsh.addToDish(beet,5.0);
        borsh.addToDish(potatos,1.0);
        borsh.addToDish(meet,5.0);
        borsh.addToDish(onion,0.5);
        borsh.setIdOfDish(idOfDish++);
        this.addDish(borsh);


        Dish soup = new Dish("Суп", DishCategory.FIRST);
        soup.addToDish(carrots, 0.5);
        soup.addToDish(meet,1.0);
        soup.addToDish(cabadge,1.0);
        soup.addToDish(onion, 0.25);
        soup.addToDish(vermicelli, 0.7);
        soup.setIdOfDish(idOfDish++);
        this.addDish(soup);

        Dish boulion = new Dish("Бульйон", DishCategory.FIRST);
        boulion.addToDish(chicken, 0.20);
        boulion.addToDish(onion, 0.2);
        boulion.addToDish(carrots, 0.50);
        boulion.addToDish(vermicelli, 0.10);
        boulion.setIdOfDish(idOfDish++);
        this.addDish(boulion);

        Dish kasha = new Dish("Гречка", DishCategory.SECOND);
        kasha.addToDish(beet, 1.0);
        kasha.addToDish(potatos, 0.5);
        kasha.addToDish(meet, 0.5);
        kasha.setIdOfDish(idOfDish++);
        this.addDish(kasha);

        Dish tea = new Dish("Чай", DishCategory.DRINK);
        tea.addToDish(carrots, 0.20);
        tea.addToDish(onion, 0.20);
        tea.setIdOfDish(idOfDish++);
        this.addDish(tea);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;

        Menu menu = (Menu) o;

        return dishList.equals(menu.dishList);

    }

    @Override
    public int hashCode() {
        return dishList.hashCode();
    }
}