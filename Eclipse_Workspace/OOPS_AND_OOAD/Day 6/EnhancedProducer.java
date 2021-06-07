
public class EnhancedProducer implements IProducer{

	String item = "shoes";
	int quantity = 100;
	
	@Override
	public boolean produceItem(String item, int quantity) {
		// TODO Auto-generated method stub
		System.out.println("From Enhanced Producer");
		if(isItemAvailable(item, quantity))
		{
			System.out.println("Item " + item + " produced.");
			System.out.println("Quantity" + quantity);
			return true;
		}
		
		System.out.println("Out of stock");
		return false;
	}
	
	private boolean isItemAvailable(String item, int quantity)
	{
		if(this.item.equals(item) && this.quantity>= quantity)
		{
			return true;
		}
		return false;
	}

}
