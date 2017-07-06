import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application
{
	private static String[] colNames = new String[] {"name","quantity","price","cost"};
	
	private Stage window;
	private TabPane tabs;
	private Scene scene;
	
	private TableView<Order> tableClient;
	private TableView<Order> tableRouter;
	private TableView<Order> tableTrader;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = new Stage();
		window.setTitle("OrderManager");
		
		tableClient = ComponentBuilder.makeTable(colNames); //THIS
		tableRouter = ComponentBuilder.makeTable(colNames); //IS
		tableTrader = ComponentBuilder.makeTable(colNames); //DIRTY
		
		makeH_Box();
		makeTabPane();
		
		scene = new Scene(tabs, 600, 600);
		window.setScene(scene);
		window.show();
	}

	private HBox makeH_Box()
	{
		HBox hBoxAllTables = new HBox(2);
		hBoxAllTables.getChildren().add(ComponentBuilder.makeTable(colNames));
		hBoxAllTables.getChildren().add(ComponentBuilder.makeTable(colNames));
		hBoxAllTables.getChildren().add(ComponentBuilder.makeTable(colNames));
		
		return hBoxAllTables;
	}
	
	private void makeTabPane()
	{
		tabs = new TabPane();
		Tab tab1 = new Tab();
		Tab tab2 = new Tab();
		Tab tab3 = new Tab();
		Tab tab4 = new Tab();
		Tab tab5 = new Tab();
		
		tab1.setText("Clients");
		tab1.setClosable(false);
		tab1.setContent(ComponentBuilder.makeTable(colNames)); //Column names go here
		
		tab2.setText("Routers");
		tab2.setClosable(false);
		tab2.setContent(ComponentBuilder.makeTable(colNames));
		
		tab3.setText("Traders");
		tab3.setClosable(false);
		tab3.setContent(ComponentBuilder.makeTable(colNames));
		
		tab4.setText("All");
		tab4.setClosable(false);
		tab4.setContent(makeH_Box());
		
		tab5.setText("Market Data");
		tab5.setClosable(false);
		tab5.setContent(DetailsTab.getBox());
		
		tabs.getTabs().addAll(tab1,tab2,tab3,tab4,tab5);
	}
}
