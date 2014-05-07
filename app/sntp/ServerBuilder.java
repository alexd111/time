/*******************************************************************************
 *        File: ServerBuilder.java
 *      Author: Morteza Ansarinia <ansarinia@me.com>
 *  Created on: November 9, 2013
 *     Project: No Time Protocol <http://time.onto.ir>
 *   Copyright: See the file "LICENSE" for the full license governing this code.
 *******************************************************************************/
package sntp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DecimalFormat;

/**
 * Builder class for SNTP server (It uses Builder/Chain-of-Commands pattern to build a sntp server).
 * Usage:
 * 		<code>Server server = new ServerBuilder().port(123).build();</code>
 * All parameters are optional.
 * 			
 */
public class ServerBuilder {

	
	/**
	 * Sample usage. Run with root access.
	 */
	public static void main(String[] args) {
		try {
			new ServerBuilder().port(123).build().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
   private int _port = 123;  // SNTP UDP port. Default value is 123.
   
   public ServerBuilder() {}

   public ServerBuilder port(int _port) {
	   this._port = _port;
	   return this;
   }
   
   public Server build() {
	   return new Server(_port);
   }
}