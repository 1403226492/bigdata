package com.zhiyou100.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAdress {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress  address = InetAddress.getLocalHost();
		//printAddressInfo(address);
		
		InetAddress[] addresses = InetAddress.getAllByName("Lenovo-ayuw");
		for (int i = 0; i < addresses.length; i++) {
			System.out.println(addresses[i].getHostAddress());
		}
		address = InetAddress.getByName("2013-20160714JG");
		System.err.println(address.getHostAddress());
		address = InetAddress.getLoopbackAddress();
		System.out.println(address);
	}

	@SuppressWarnings("unused")
	private static void printAddressInfo(InetAddress  address){
		String hostName = address.getHostName();
		//String ip = parseIpString(address.getAddress());
		String ip = address.getHostAddress();
		System.out.println(hostName +" = " + ip);
		
	}

	@SuppressWarnings("unused")
	private static String parseIpString(byte[] address) {
		String ret = null;
		ret = parseByteIp(address[0]) +"." + parseByteIp(address[1])+"." + parseByteIp(address[2]) +"." + parseByteIp(address[3]);
		return ret;
		
	}
	
	private static String parseByteIp(byte ip){
		int fact = 255;
		int ret = fact & ip; 
		
		return ret+"";
	}
}
