package com.ailpha.practice.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class AIClient {

	private Socket server;
	private String host;
	private int port;

	public AIClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	private boolean isConnected() {
		if (this.server == null) {
			return false;
		}
		boolean isCon = true;
		try {
			this.server.sendUrgentData(1);
		} catch (Exception e) {
			System.out.println("Client Connection is broken . Please restart .");
			isCon = false;
		}
		return isCon;
	}

	public void start() {
		try {
			// set data object
			this.server = new Socket(this.host, this.port);
			
			if(this.isConnected()==false){
				return ;
			}

			boolean flag = true;
			Scanner clientInput = new Scanner(System.in);
			clientInput.useDelimiter("\n");
			PrintStream clientOutput = new PrintStream(this.server.getOutputStream());
			Scanner serverInput = new Scanner(this.server.getInputStream());
			serverInput.useDelimiter("\n");

			System.out.println("Connecting ... ");

			while (flag) {
				
				if(this.isConnected()==false){
					break;
				}

				System.out.print("Myself:");

				if (clientInput.hasNextLine()) {

					String inputStr = clientInput.nextLine().trim();
					clientOutput.println(inputStr);

					if (serverInput.hasNextLine()) {
						System.out.println(serverInput.nextLine());
					}

					if ("byebye".equalsIgnoreCase(inputStr)) {
						flag = false;
					}
				}
			}

			serverInput.close();
			clientOutput.close();
			clientInput.close();
			this.server.close();

		} catch (Exception e) {
			System.out.println("Please restart.");
			System.err.println(e);
		}
	}
}

public class AIClientInstance {

	public static void main(String[] args) throws Exception {
		new AIClient("localhost", 8888).start();
	}

}
