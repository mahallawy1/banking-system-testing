package test_cases;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	public static void main(String[] args) {
		//Trial trial = new Trial();
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		
		Parent root = FXMLLoader.load(getClass().getResource("Home1.fxml"));
		
		Scene scene = new Scene(root);
//		Image icon = new Image("Images/bank.png");
		
//		stage.getIcons().add(icon);
		stage.setTitle("Banking");
		stage.setScene(scene);
		stage.show();
	}
	
	
}
