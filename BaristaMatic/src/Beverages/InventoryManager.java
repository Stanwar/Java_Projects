package Beverages;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
/*
 * Static Class to load details related to Inventory. 
 * This class will also give current Inventory for each ingredient
 * */
public class InventoryManager {

	// Only have one copy of the inventory
	// Sorted Map to have inventory in a sorted manner
	public static TreeMap<String, Integer> inventory = new TreeMap<String, Integer>();

	// Made constructor private
	private InventoryManager(){
		 
	}
	
	//Update ingredient in inventory
	public static void reduceIngredient(Ingredient ingredient){
		int quantity = inventory.get(ingredient.name());
		
		if(quantity > 0){
			inventory.put(ingredient.name(),inventory.get(ingredient.name())-1);
		}
	}
	
	//Stock/Restock
	public static void loadInventory(){
		inventory.put(new Cocoa().name(), 10);
		inventory.put(new Coffee().name(), 10);
		inventory.put(new Cream().name(), 10);
		inventory.put(new DecafCoffee().name(), 10);
		inventory.put(new Expresso().name(), 10);
		inventory.put(new FoamedMilk().name(), 10);
		inventory.put(new SteamedMilk().name(), 10);
		inventory.put(new Sugar().name(), 10);
		inventory.put(new WhippedCream().name(), 10);
		
	}
	// Display Ingredient Quantities
	public static void ingredientList(){
		System.out.println("Inventory:");
		
		for(String ingredient : inventory.keySet()){
			System.out.println(ingredient + ","+ inventory.get(ingredient));
		}
	}
}
