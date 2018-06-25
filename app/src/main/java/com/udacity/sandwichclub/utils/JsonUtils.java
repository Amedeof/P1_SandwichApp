package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwhich = new JSONObject(json);

            // Go to the root "name"
            JSONObject name = sandwhich.getJSONObject("name");
            // Get key "mainName"
            String mainName = name.getString("mainName");

            // Go to Array "alsoKnownAs"
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownList = new ArrayList<>();

            // Get keyvalues from alsoKnownList
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alsoKnownList.add(alsoKnownAs.getString(i));
            }

            // Get key "placeOfOrigin"
            String placeOfOrigin = sandwhich.getString("placeOfOrigin");
            // Get key "description"
            String description = sandwhich.getString("description");
            // Get key "image"
            String image = sandwhich.getString("image");

            // Go to Array "ingredients"
            JSONArray ingredients = sandwhich.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();

            // Get keyvalues from ingredientList
            for (int j = 0; j < ingredients.length(); j++) {
                ingredientsList.add(ingredients.getString(j));
            }

            // Pass the new Sandwich adapter
            return new Sandwich(mainName, alsoKnownList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }
}