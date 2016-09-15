import java.net.DatagramSocket;

public class Server {

	public static void main(String[] args) {
		new Server().run(23460);
	}
	
	public void run(int port){
		try{
			DatagramSocket socket = new DatagramSocket(port);
			System.out.println();
		}
		catch(Exception e){
			System.err.println(e);
		}
		
		
		
	}

}
