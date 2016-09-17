import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class Server implements Runnable{

	public static DatagramSocket socket;
	public static int port = 23459;
	
	public Server() throws SocketException{
		socket = new DatagramSocket(port);
		socket.setSoTimeout(5000);
	}
	
	public void run(){
		try{
			System.out.println("Starting server... ");
			byte[] receiveData =  new byte[8];
			System.out.printf("Listening to address %s:%s...", "127.0.0.1", port);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			
			while(true){
				socket.receive(receivePacket);
				String text = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("Received: " + text);
				InetAddress returnAddress = receivePacket.getAddress();
				
				String sendText = "Received \"" + text + "\".";
				byte[] sendData = sendText.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, returnAddress, receivePacket.getPort());
				socket.send(sendPacket);
			}
			
		}
		catch(SocketTimeoutException e){
			System.err.println(e);
			if(!Thread.currentThread().isInterrupted()){
				run();
			}
			else{
				socket.close();
				System.out.println("Closed server.");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public boolean status(){
		return socket.isClosed();
	}

}
