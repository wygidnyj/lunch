package complex.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import complex.objects.Dish;

import java.util.List;

public class DishDAOtoJson {

    private static Gson gson = new GsonBuilder().create();

    public static String menuToJson(List<Dish> dishList) {
        Dish[] dishes = (Dish[]) dishList.toArray();

        return gson.toJson(dishes, Dish[].class);

    }

    public static Dish jsonToMenu(String json) {
        return gson.fromJson(json, Dish.class);
    }
}

