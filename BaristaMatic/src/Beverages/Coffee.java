package Beverages;
/*
 * Ingredient : Coffee Class
 * */
public class Coffee extends BaseCoffees{
	
	@Override
	public float price(){
		return 0.75f;
	}
	
	@Override
	public String name(){
		return "Coffee";
	}
}
