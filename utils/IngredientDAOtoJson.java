package complex.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import complex.objects.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IngredientDAOtoJson {



    private static Gson gson = new GsonBuilder().create();

    public static String ingredientListToJson(List<Ingredient> ingredients) {

        return gson.toJson(ingredients, List.class);
    }

    public static ArrayList<Ingredient> ingredientListFromJson(String json) {

        Ingredient[] ingredientsFromDB;
        ingredientsFromDB = gson.fromJson(json, Ingredient[].class);

        return new ArrayList<>(Arrays.asList(ingredientsFromDB));
    }
}
