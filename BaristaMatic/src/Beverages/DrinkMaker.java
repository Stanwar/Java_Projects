package Beverages;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * This class will be driving class for creating drinks. This is static as we don't need to create instances of this.
 * This class helps to decouple concrete classes in Drink from the Main Class.
 * */
public class DrinkMaker {
	
	public static HashMap<String,ArrayList<String>> drinkIngredient = new HashMap<String,ArrayList<String>>();
	
	
	private DrinkMaker(){
		
	}
	// Add Drinks and their ingredients for later use
	public static void addDrink(String name, String[] ingredientName){

		for(String ingredient : ingredientName){
			if(drinkIngredient.get(name) != null){
				drinkIngredient.get(name).add(ingredient);
			}else{
				ArrayList<String> ar = new ArrayList<String>();
				ar.add(ingredient);
				drinkIngredient.put(name,ar);
			}
		}
		
		
	}
	// Build a Drink and get its attributes for example : Cost , etc
	public static Drink getDrink(String drinkName) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException{
		
		Drink drink = new Drink();
		
		// Get Ingredient List for the Drink 
		ArrayList<String> ingredients = drinkIngredient.get(drinkName);
		
		for(String ingredient : ingredients){
			
			if(InventoryManager.inventory.containsKey(ingredient)){
				//System.out.println("ingredient name : " + ingredient);
				ingredient = ingredient.replace(" ", "");
				Class clazz = Class.forName("Beverages." + ingredient);
				Ingredient c= (Ingredient) clazz.newInstance();
				//System.out.println(c.name());
				drink.addIngredient(c);
			}
		}
		return drink;
	}
	// Method to prepare any idea of drink
	public static void prepareDrink(String drinkName) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		//Drink drink = new Drink();
		
		// Get Ingredient List for the Drink 
		ArrayList<String> ingredients = drinkIngredient.get(drinkName);
		
		// Based on Drink, Get Ingredients and Add each to list
		for(String ingredient : ingredients){
			if(InventoryManager.inventory.containsKey(ingredient)){
				ingredient = ingredient.replace(" ", "");
				Class clazz = Class.forName("Beverages." + ingredient);
				Ingredient c= (Ingredient) clazz.newInstance();
				//System.out.println(c.name());
				InventoryManager.reduceIngredient(c);
			}
		}
		
	}
	
	public static boolean isDrinkAvailable (String drinkName){
		ArrayList<String> drinkIngredients = drinkIngredient.get(drinkName);
		//System.out.println(drinkIngredients.size());
		HashMap<String, Integer> ingredientCount = new HashMap<String, Integer>();
		
		// Get all the counts of ingredients needed 
		for(String ingredient :drinkIngredients){
			if(ingredientCount.get(ingredient) != null){
				ingredientCount.put(ingredient, ingredientCount.get(ingredient) + 1);
			}else{
				ingredientCount.put(ingredient, 1);
			}
		}
		
		// If inventory count is less than required count, return false
		for(String ingredient :drinkIngredients){
			if(InventoryManager.inventory.get(ingredient)< ingredientCount.get(ingredient)){
				return false;
			}
		}
		return true;
	}	
}
