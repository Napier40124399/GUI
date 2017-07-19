package Builders;

import java.util.ArrayList;
import java.util.Random;

import DataStore.Order;
import DataStore.PendingOrders;
import DataStore.UsageData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataGenerator
{
	private static int orderId = 0;
	public static ObservableList<Order> generateOrders()
	{
		ObservableList<Order> orders = FXCollections.observableArrayList();

		for (int i = 0; i < 70; i++)
		{
			orders.add(new Order("VOD"));
		}

		return orders;
	}
	
	public static ObservableList<UsageData> generateUsageData()
	{
		ObservableList<UsageData> usageData = FXCollections.observableArrayList();

		usageData.add(new UsageData("clients",100,23.5));
		usageData.add(new UsageData("routers",5,11.6));
		usageData.add(new UsageData("traders", 19,13.8));
		usageData.add(new UsageData("total",124,48.9));

		return usageData;
	}
	
	public static ArrayList<Double> genMarketPrice(int size)
	{
		ArrayList<Double> array = new ArrayList<>(size);
		Random r = new Random();
		Double start = r.nextDouble() * 200 + 50;

		for (int i = 0; i < size; i++)
		{
			double temp = 9 * r.nextGaussian();
			array.add(start + temp);
		}

		return array;
	}
	
	public static ObservableList<PendingOrders> generatePendingOrders(int size)
	{
		Random r = new Random();
		ObservableList<PendingOrders> pendingOrders = FXCollections.observableArrayList();
		for(int i = 0; i < size; i++)
		{
			pendingOrders.add(new PendingOrders("N/A",r.nextInt(2000000),orderId++, orderId++,r.nextFloat()*2,"Pending"));
		}
		return pendingOrders;
	}
}
