import com.sun.glass.ui.Application;
import com.sun.glass.ui.Robot;

import javafx.scene.input.KeyCode;

@SuppressWarnings("restriction")
public class Skynet extends Thread{

	public static Robot robot;
	public static KeyCode key;
	
	public Skynet(){
		robot = Application.GetApplication().createRobot();
	}
	
	public void keypress(String command){
		switch(command){
			case "up": key = KeyCode.UP; break;
			case "down": key = KeyCode.DOWN; break;
			case "left": key = KeyCode.LEFT; break;
			case "right": key = KeyCode.RIGHT; break;
			default: key = null; break;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void run(){
		if(!(key == null)){
			robot.keyPress(key.impl_getCode());
		}
		else{
			System.out.println("Keypress is null. Not doing anything.");
		}
	}
	
}
