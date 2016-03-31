package Beverages;

import java.util.ArrayList;
import java.util.List;

/*
 * This class will create a type of drink based on the ingredients
 * */

public class Drink {
	// List to hold ingredients for each drink
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public void addIngredient(Ingredient ingredient){
		ingredients.add(ingredient);
	}
	
	// Calculate Cost for each drink
	public float getTotalCost(){
		float cost = 0.00f;
		//Add cost for each ingredient
		for(Ingredient ingredient : ingredients){
			cost = cost + ingredient.price();
		}
		// Returning Total Cost 
		return cost;
	}
}
