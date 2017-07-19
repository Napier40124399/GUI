package DataStore;

/**
 * Created by James on 7/6/2017.
 */
public class PendingOrders
{
	private String instrument;
	private int quantity;
	private int orderId;
	private int clientId;
	private float price;
	private String orderStatus;
	
	public PendingOrders(String instrument, int quantity, int orderId, int clientId, float price, String orderStatus)
	{
		this.instrument = instrument;
		this.quantity = quantity;
		this.orderId = orderId;
		this.clientId = clientId;
		this.price = price;
		this.orderStatus = orderStatus;
	}
	
	public String getInstrument ()
	{
		return instrument;
	}
	
	public int getQuantity ()
	{
		return quantity;
	}
	
	public int getOrderId ()
	{
		return orderId;
	}
	
	public int getClientId ()
	{
		return clientId;
	}
	
	public float getPrice ()
	{
		return price;
	}
	
	public String getOrderStatus ()
	{
		return orderStatus;
	}
}
