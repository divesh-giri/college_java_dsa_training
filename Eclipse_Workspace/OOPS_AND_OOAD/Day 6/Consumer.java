
public class Consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String item = "shoes";
		int quantity = 100;
		IProducer iproducer = ProducerFactory.getProduct();
		iproducer.produceItem(item, quantity);
		
	}

}
