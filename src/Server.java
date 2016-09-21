import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server extends Thread{

	public static DatagramSocket socket;
	public static int port = 23459;
	public boolean ranOnce = false;
	
	public Server() throws SocketException{
		socket = new DatagramSocket(port);
		//socket.setSoTimeout(5000);
	}
	
	public void run(){
		try{
				System.out.println("Starting server... ");
				byte[] receiveData =  new byte[8];
				System.out.printf("Listening to address %s:%s...", "127.0.0.1", port);
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				
				while(true){
						ranOnce = true;
						socket.receive(receivePacket);
						String text = new String(receivePacket.getData(), 0, receivePacket.getLength());
						System.out.println("Received: \"" + text + "\".");
						
						Skynet robot = new Skynet();
						robot.keypress(text);
						robot.start();
						
						InetAddress returnAddress = receivePacket.getAddress();
						
						String sendText = "Received \"" + text + "\".";
						byte[] sendData = sendText.getBytes("UTF-8");
						DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, returnAddress, receivePacket.getPort());
						socket.send(sendPacket);
				}
		}
		catch(Exception e){
			//System.out.println("\n" + e);
			System.out.println("Server closed.");
		}
	}
	
	public void close() throws SocketException{
		socket.close();
	}
	
	public boolean status(){
		return socket.isConnected();
	}

}
