
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

	static Label text = new Label("This is text.");
	static Button hello = new Button("Click me!");
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.getIcons().add(new Image("file:/home/spiral6/Pictures/hologram.jpg"));
		
		hello.setOnAction(e -> click());
		
		VBox v = new VBox();
		v.setPadding(new Insets(10));
		v.getChildren().add(text);
		v.getChildren().add(hello);
		
		Scene scene = new Scene(v, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello world!");
		primaryStage.show();
	}
	
	public static void click(){
		text.setText("This is still text.");
		hello.setText("Clicking me again does nothing.");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
