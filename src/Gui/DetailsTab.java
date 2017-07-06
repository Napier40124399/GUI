package Gui;

import Builders.ComponentBuilder;
import Builders.DataGenerator;
import DataStore.UsageData;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class DetailsTab
{
	private static Tab tab;
	private static VBox box;

	private static Label lblClients;
	private static Label lblRouters;
	private static Label lblTraders;
	private static Label lblTotal;

	private static TextField txtClients;
	private static TextField txtRouters;
	private static TextField txtTraders;
	private static TextField txtTotal;

	public DetailsTab()
	{
		initialize();
	}

	public static void initialize()
	{
		box = new VBox();
		box.getChildren().add(makeStatsTable());
		box.getChildren().add(makeChart());

		tab = new Tab();
		tab.setText("Details");
		tab.setClosable(false);
		tab.setContent(box);
	}

	private static TableView<UsageData> makeStatsTable()
	{
		String[] columns = new String[]{"manager","connected","msgPerSec"};
		TableView<UsageData> table = new TableView<>();
		table.setItems(DataGenerator.generateUsageData());
		for (String s : columns)
		{
			TableColumn<UsageData, String> col = new TableColumn<>(s);
			col.setMinWidth(50);
			col.setCellValueFactory(new PropertyValueFactory<>(s));
			table.getColumns().add(col);
		}
		table.setMaxHeight(120);
		table.setFixedCellSize(20);
		return table;
	}
	
	private static VBox makeStatsText()
	{
		// Labels
		lblClients = ComponentBuilder.makeLabel("Clients", 80);
		lblRouters = ComponentBuilder.makeLabel("Routers", 80);
		lblTraders = ComponentBuilder.makeLabel("Traders", 80);
		lblTotal = ComponentBuilder.makeLabel("Total", 80);

		// Text Fields
		txtClients = ComponentBuilder.makeTextField(50, false);
		txtRouters = ComponentBuilder.makeTextField(50, false);
		txtTraders = ComponentBuilder.makeTextField(50, false);
		txtTotal = ComponentBuilder.makeTextField(50, false);

		// VBox
		VBox box = new VBox();
		box.getChildren().add(ComponentBuilder.putInHBox(lblClients, txtClients));
		box.getChildren().add(ComponentBuilder.putInHBox(lblRouters, txtRouters));
		box.getChildren().add(ComponentBuilder.putInHBox(lblTraders, txtTraders));
		box.getChildren().add(ComponentBuilder.putInHBox(lblTotal, txtTotal));

		return box;
	}

	private static LineChart<Number,Number> makeChart()
	{
		NumberAxis x = new NumberAxis();
		x.setLabel("X axis");
		NumberAxis y = new NumberAxis();
		y.setLabel("Y axis");

		LineChart<Number,Number> chart = new LineChart<Number, Number>(x, y);
		chart.setTitle("Test Chart");
		chart.setCreateSymbols(false);
		chart.setMaxHeight(900);

		ComponentBuilder.addSeries(DataGenerator.genMarketPrice(100), chart);
		ComponentBuilder.addSeries(DataGenerator.genMarketPrice(100), chart);
		ComponentBuilder.addSeries(DataGenerator.genMarketPrice(100), chart);
		ComponentBuilder.addSeries(DataGenerator.genMarketPrice(100), chart);
		ComponentBuilder.addSeries(DataGenerator.genMarketPrice(100), chart);
		
		return chart;
	}

	public static VBox getBox()
	{
		initialize();
		return box;
	}
}
