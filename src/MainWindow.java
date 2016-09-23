
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
	private static Robot robot;
	static Server server;
	static MainWindow window;
	
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

	
	public static void main(String[] args) throws SocketException, AWTException {
		robot = new Robot();
		server = new Server();
		launch(args);
	}
	
	
	public static void keypress(String command){
		
		System.out.println(command);
		
		int key;
		switch(command){
			case "up": key = KeyEvent.VK_UP; break;
			case "down": key = KeyEvent.VK_DOWN; break;
			case "left": key = KeyEvent.VK_LEFT; break;
			case "right": key = KeyEvent.VK_RIGHT; break;
			default: key = 0; break;
		}
		if(!(key == 0)){
			robot.keyPress(key);
			robot.keyRelease(key);
			System.out.println("Printed " + command + ".");
		}
		else{
			System.out.println("Keypress is null. Not doing anything.");
		}
	}
}
