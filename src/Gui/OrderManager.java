package Gui;

import DataStore.Order;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OrderManager extends Application
{
	private Stage window;
	private TableView<Order> table;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = new Stage();
		window.setTitle("OrderManager");
		
		//Name Column
		TableColumn<Order, String> nameCol = new TableColumn<>("Name");
		nameCol.setMinWidth(50);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		//Quantity col
		TableColumn<Order, Integer> quCol = new TableColumn<>("Quantity");
		quCol.setMinWidth(50);
		quCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		//Price Column
		TableColumn<Order, Integer> priceCol = new TableColumn<>("Price");
		priceCol.setMinWidth(50);
		priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
		//Cost Columns
		TableColumn<Order, Integer> costCol = new TableColumn<>("Cost");
		costCol.setMinWidth(50);
		costCol.setCellValueFactory(new PropertyValueFactory<>("cost"));
		
		table = new TableView<>();
		table.setItems(generateOrders());
		table.getColumns().addAll(nameCol, quCol, priceCol, costCol);
		
		//TreeView
		TreeView<String> tree;
		TreeItem<String> root, clients, routers, traders;
		root = new TreeItem<>();
		root.setExpanded(true);
		
		
		clients = makeBranch("Clients", root);
		makeBranch("buying", clients);
		
		routers = makeBranch("Routers", root);
		makeBranch("routing", routers);
		
		traders = makeBranch("Traders", root);
		makeBranch("trades", traders);
		
		tree = new TreeView<>(root);
		tree.setShowRoot(false);
		
		StackPane layout = new StackPane();
		layout.getChildren().add(tree);
		
//		VBox box = new VBox();
//		box.getChildren().addAll();
		
		Scene scene = new Scene(layout, 600,600);
		window.setScene(scene);
		window.show();
	}
	
	private TreeItem<String> makeBranch(String name, TreeItem<String> parent)
	{
		TreeItem<String> treeItem = new TreeItem<>(name);
		
		treeItem.setExpanded(true);
		parent.getChildren().add(treeItem);
		
		return treeItem;
	}
	
	private TreeItem<TableView<Order>> makeBranch2(TableView<Order> table, TreeItem<String> parent)
	{
		TreeItem<TableView<Order>> treeItem = new TreeItem<>(table);
		
		treeItem.setExpanded(true);
		//parent.getChildren().add(treeItem);

		return treeItem;
	}
	
	private ObservableList<Order> generateOrders()
	{
		ObservableList<Order> orders = FXCollections.observableArrayList();
		
		for(int i = 0; i < 70; i++)
		{

			orders.add(new Order("VOD"));
		}
		
		return orders;
	}
}
