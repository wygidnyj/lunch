package complex.objects;

public class Complex {
    /**
     * first dish
     */
    private Dish first;
    /**
     * second dish
     */
    private Dish second;
    /**
     * drink
     */
    private Dish drink;
    /**
     * price of complex
     */

    public Complex() {
    }
    public Complex(Dish first, Dish second, Dish drink){
        this.first = first;
        this.second = second;
        this.drink = drink;

    }

    @Override
    public String toString() {
        return first+" "+second+" "+drink;
    }

    public Dish getFirst() {
        return first;
    }

    public void setFirst(Dish first) {
        this.first = first;
    }

    public Dish getSecond() {
        return second;
    }

    public void setSecond(Dish second) {
        this.second = second;
    }

    public Dish getDrink() {
        return drink;
    }

    public void setDrink(Dish drink) {
        this.drink = drink;
    }

    public Double getPriceOfComplex() {
        return first.getDishPrice()+second.getDishPrice()+drink.getDishPrice();
    }


}
