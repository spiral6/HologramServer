
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindow extends Application {

	static Label text = new Label("This is text.");
	
	@Override
	public void start(Stage primaryStage) {
		
		Button hello = new Button("Click me!");
		hello.setOnAction(e -> click());
		
		
		Pane p = new Pane();
		p.getChildren().add(hello);
		p.getChildren().add(text);
		
		Scene scene = new Scene(p, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello world!");
		primaryStage.show();
	}
	
	public static void click(){
		text.setText("This is still text.");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
