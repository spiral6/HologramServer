
import java.net.SocketException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	private static Label status = new Label("Server has not started.");
	private static Button start = new Button("Start server");
	static Server server;
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.getIcons().add(new Image("/hologram.jpg"));
		
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
		
		Scene scene = new Scene(v, 200, 100);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello world!");
		primaryStage.show();
	}
	
	public static void click() throws SocketException, InterruptedException{
		if(start.getText().equals("Start server")){
			status.setText("Server has started.");
			start.setText("Stop server");
			if(!server.ranOnce){
				server.start();
			}
			else{
				server = new Server();
				server.start();
			}
			
			//TODO Start the server program
		}
		else if(start.getText().equals("Stop server")){
			//server.interrupt();
			status.setText("Server has closed.");
			start.setText("Start server");
			server.close();
		}
	
	}

	public static void main(String[] args) throws SocketException {
		server = new Server();
		launch(args);
	}
}
