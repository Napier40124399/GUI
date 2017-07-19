package Gui;

import Builders.ComponentBuilder;
import DataStore.PendingOrders;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
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
	    
        
        
        scene = new Scene(ComponentBuilder.putInHBox());
        window.setScene(scene);
        window.show();
    }
    
    private void makeIncomingTable()
    {
    	TableView<PendingOrders> table = new TableView<PendingOrders>();
    }
}
