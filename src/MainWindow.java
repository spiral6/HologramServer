
import java.net.SocketException;

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
	static Thread server;
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.getIcons().add(new Image("file:/home/spiral6/Pictures/hologram.jpg"));
		
		start.setOnAction(e -> {
			try {
				click();
			} catch (SocketException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		VBox v = new VBox();
		v.setPadding(new Insets(10));
		v.getChildren().add(status);
		v.getChildren().add(start);
		
		Scene scene = new Scene(v, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello world!");
		primaryStage.show();
	}
	
	public static void click() throws SocketException, InterruptedException{
		if(start.getText().equals("Start server")){
			status.setText("Server has started.");
			start.setText("Stop server");
			server.start();
			//TODO Start the server program
		}
		else if(start.getText().equals("Stop server")){
			server.interrupt();
			status.setText("Server has closed.");
			start.setText("Start server");
			server.wait();
			server = new Thread(new Server());
		}
	
	}

	public static void main(String[] args) throws SocketException {
		server = new Thread(new Server());
		launch(args);
	}
}
