package Beverages;

public class DecafCoffee extends BaseCoffees {
	@Override
	public float price(){
		return 0.75f;
	}
	
	@Override
	public String name(){
		return "Decaf Coffee";
	}
}
