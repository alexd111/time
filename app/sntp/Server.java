/*******************************************************************************
 *        File: Server.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: November 9, 2013
 *     Project: No Time Protocol <http://time.onto.ir>
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package sntp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {  

	private Message response;
	private Message request;
	private byte[] buffer;

	private int _port = -1; // Default is 123 UDP
	
	private DatagramPacket packet;  
	private DatagramSocket socket;

	public void run(){  
		try{  
			response = new Message();
			response.stratum = 1;
			response.precision = -6;
			response.delay = 0.0;
			response.refId = "LOCL".getBytes();
			buffer = response.toByteArray();

			System.out.println("Server started!"); 
			packet = new DatagramPacket(buffer, buffer.length);        
			socket = new DatagramSocket(_port);  

			while(true){           
				socket.receive(packet);  

				System.out.println("Request from "+packet.getAddress()+":"+packet.getPort());                

				buffer = packet.getData();
				request = new Message(buffer);

				response.orgTime = request.xmtTime;
				response.recTime = NtpTimestamp.now();
				response.xmtTime = NtpTimestamp.now();

				buffer = response.toByteArray();
				DatagramPacket resp = new DatagramPacket(buffer,buffer.length,packet.getAddress(),packet.getPort());  
				socket.send(resp);  
			}  
		}    

		catch(Exception e){  
			e.printStackTrace();
			System.exit(1);  
		}   
	}

	public Server(int port) {
		this._port = port;
	}
   
}
