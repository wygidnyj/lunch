package complex.utils;


import complex.objects.Dish;
import complex.objects.Info;
import complex.objects.Ingredient;

public class MainDB {
    private DishDAOtoDB dDAO;
    private IngredientDAOtoDB iDAO;
    private MetaWriter metaWriter;
    public MainDB() {
        dDAO = new DishDAOtoDB();
        iDAO = new IngredientDAOtoDB();
        metaWriter = new MetaWriter();
    }
    public void saveDish(Dish dish){
        dDAO.addDish(dish);
        int dishID = dDAO.getIdByNAme(dish.getDishName());

        for (Ingredient i: dish.getIngredients()){
            iDAO.addIngredient(i);
            Info info = new Info();

            info.setIdIngr(iDAO.getIdByName(i.getName()));
            info.setIdDish(dishID);
            info.setWeight(i.getWeight());
            metaWriter.addInfo(info);
        }
    }
}
