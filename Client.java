import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * Qing 22036164, 9 Aug 2023 1:34:12 pm
 */
public class Client implements Runnable {

	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private boolean done;

	@Override
	public void run() {
		try {
			Socket client = new Socket("10.175.3.135", 9999);
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));

			InputHandler inHandler = new InputHandler();
			Thread t = new Thread(inHandler);
			t.start();

			String inMessage;
			while ((inMessage = in.readLine()) != null) {
				System.out.println(inMessage);
			}
		} catch (IOException e) {
			shutdown();
		}
	}

	public void shutdown() {
		done = true;
		try {
			in.close();
			out.close();
			if (!client.isClosed()) {
				client.close();
			}
		} catch (IOException e) {
			// Not needed
		}
	}

	class InputHandler implements Runnable {
		@Override
		public void run() {
			try {
				BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
				while (!done) {
					String message = inReader.readLine();
					if(message.equals("/quit")) {
						inReader.close();
						shutdown();
					}else {
						out.println(message);
					}
				}
				
			}catch(IOException e) {
				shutdown();
			}
		}
	}
	public static void main(String[] args) {
		Client client = new Client();
		client.run();
	}
}
