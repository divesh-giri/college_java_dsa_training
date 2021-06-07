
public class Producer implements IProducer {
	String item = "shoes";
	int quantity = 100;
	
	public boolean produceItem(String item, int quantity)
	{
		System.out.println("From Producer");
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
