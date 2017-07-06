package DataStore;

public class Order
{
	private String name;
	private int quantity;
	private int price;
	private int cost;

	public Order(String name, int quantity, int price)
	{
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.cost = price * quantity;
	}

	public Order(String name)
	{
		double temp = Math.random() * 500 + 1;
		int quantity = (int) temp;
		temp = Math.random() * 5 + 1;
		int price = (int) temp;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.cost = this.price * this.quantity;
	}

	public String getName()
	{
		return name;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public int getPrice()
	{
		return price;
	}

	public int getCost()
	{
		return cost;
	}

	public String[] getAll()
	{
		return new String[]
		{ name, quantity + "", price + "", cost + "" };
	}
}
