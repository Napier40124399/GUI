package Builders;

import java.util.ArrayList;

import DataStore.Order;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ComponentBuilder
{
	public static Label makeLabel(String labelText, int minWidth, int minHeight)
	{
		Label lbl = makeLabel(labelText, minWidth);
		lbl.setMinHeight(minHeight);

		return lbl;
	}

	public static Label makeLabel(String labelText, int minWidth)
	{
		Label lbl = new Label();

		lbl.setText(labelText);
		lbl.setMinWidth(minWidth);

		return lbl;
	}

	public static TextField makeTextField(int minWidth, boolean editable)
	{
		TextField txt = new TextField();

		txt.setMinWidth(minWidth);
		txt.setMaxWidth(minWidth);
		txt.setEditable(editable);
		txt.setMouseTransparent(!editable);
		txt.setFocusTraversable(editable);

		return txt;
	}

	public static TableView<Order> makeTable(String[] columns)
	{
		TableView<Order> table = new TableView<>();
		table.setItems(DataGenerator.generateOrders());
		for (String s : columns)
		{
			TableColumn<Order, String> col = new TableColumn<>(s);
			col.setMinWidth(50);
			col.setCellValueFactory(new PropertyValueFactory<>(s));
			table.getColumns().add(col);
		}

		return table;
	}
	
	public static void addSeries(ArrayList<Double> xAxis, ArrayList<Double> yAxis, LineChart<Number,Number> chart)
	{
		XYChart.Series series = new XYChart.Series();
		for (int i = 0; i < xAxis.size(); i++)
		{
			series.getData().add(new XYChart.Data(xAxis.get(i), yAxis.get(i)));
		}
		chart.getData().add(series);
	}

	public static void addSeries(ArrayList<Double> yAxis, LineChart<Number,Number> chart)
	{
		XYChart.Series series = new XYChart.Series();
		for (int i = 0; i < yAxis.size(); i++)
		{
			series.getData().add(new XYChart.Data(i, yAxis.get(i)));
		}
		chart.getData().add(series);
	}
	
	/**
	 * <h1>putInHBox</h1>
	 * VBox organises this way:<p>
	 * comp1<p>
	 * -----<p>
	 * comp2<p>
	 * @see {@link Builders.ComponentBuilder#putInVBox(Node...) putInVBox}
	 * @param components (Node) - basicaly javafx components
	 * @return {@link HBox}
	 */
	public static HBox putInHBox(Node... components)
	{
		HBox box = new HBox();
		box.getChildren().addAll(components);
		return box;
	}
	
	/**
	 * <h1>putInVBox</h1>
	 * VBox organises this way:<p>
	 * comp1 | comp2<p>
	 * @see {@link Builders.ComponentBuilder#putInHBox(Node...) putInHBox}
	 * @param components (Node) - basicaly javafx components
	 * @return {@link VBox}
	 */
	public static VBox putInVBox(Node... components)
	{
		VBox box = new VBox();
		box.getChildren().addAll(components);
		return box;
	}
}
