
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	static Label status = new Label("Server has not started.");
	static Button start = new Button("Start server");
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.getIcons().add(new Image("file:/home/spiral6/Pictures/hologram.jpg"));
		
		start.setOnAction(e -> click());
		
		VBox v = new VBox();
		v.setPadding(new Insets(10));
		v.getChildren().add(status);
		v.getChildren().add(start);
		
		Scene scene = new Scene(v, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello world!");
		primaryStage.show();
	}
	
	public static void click(){
		if(status.getText().equals("Server has not started.")){
			status.setText("Server has started.");
			//TODO Start the server program
		}
		else{
			System.out.println("Server has already started. No need to click this button.");
		}
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
