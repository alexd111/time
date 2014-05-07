/*******************************************************************************
 *        File: ClientBuilder.java
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
 * Builder class for SNTP client (It uses Builder/Chain-of-Commands pattern to build a sntp client).
 * Usage:
 * 		<code>Client client = new ClientBuilder().host("time.apple.com").port(123).timeout(10000).build();</code>
 * All parameters are optional.
 * 			
 */
public class ClientBuilder {

	
	/**
	 * Sample usage
	 */
	public static void main(String[] args) {
		try {
			new ClientBuilder().host("localhost").build().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
   private int _port = 123;  // SNTP UDP port. Default value is 123.
   private String _host = "time.apple.com"; // NTP server address.
   private int _timeout = 0; // Connection timeout. Default value is 0.
   
   public ClientBuilder() {}

   public ClientBuilder host(String _host) {
	   this._host = new String(_host);
	   return this;
   }

   public ClientBuilder port(int _port) {
	   this._port = _port;
	   return this;
   }
   
   public ClientBuilder timeout(int _timeout) {
	   this._timeout = _timeout;
	   return this;
   }

   public Client build() {
	   return new Client(_port, _host, _timeout);
   }
}