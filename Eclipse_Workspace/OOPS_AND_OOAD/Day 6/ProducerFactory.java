import java.util.ResourceBundle;

public class ProducerFactory{
	private ProducerFactory() { }
	
	public static IProducer getProduct()
	{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String className = rb.getString("producerClass");
		IProducer iProducer = null;
		try
		{
			iProducer =(IProducer) Class.forName(className).newInstance();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured: "+e);
		}
		return iProducer; 
	}

}
