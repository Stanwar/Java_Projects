package Beverages;

public class Sugar extends Condiments{

	@Override
	public float price(){
		return 0.25f;
	}
	
	@Override
	public String name(){
		return "Sugar";
	}
}
