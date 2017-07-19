package Launchers;

import Builders.ComponentBuilder;
import Builders.DataGenerator;
import DataStore.PendingOrders;
import DataStore.UsageData;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by James on 7/6/2017.
 */
public class TraderGUI extends Application
{
    private Stage window;
    private Scene scene;
    
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = new Stage();
        window.setTitle("TraderGUI");
	    
        
        
        scene = new Scene(ComponentBuilder.putInHBox(makeIncomingTable(), makeIncomingTable()));
        window.setScene(scene);
        window.show();
    }
    
    private TableView<PendingOrders> makeIncomingTable()
    {
    	String[] columns = new String[]{"orderId","clientId","instrument","quantity","price","orderStatus"};
    	TableView<PendingOrders> table = new TableView<>();
    	table.setItems(DataGenerator.generatePendingOrders(37));
	    for (String s : columns)
	    {
		    TableColumn<PendingOrders, String> col = new TableColumn<>(s);
		    col.setMinWidth(50);
		    col.setCellValueFactory(new PropertyValueFactory<>(s));
		    table.getColumns().add(col);
	    }
	    //table.setMaxHeight(120);
	    table.setFixedCellSize(30);
	    return table;
    }
}
