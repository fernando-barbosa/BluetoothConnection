package com.example.conexaobluetooth;

public class Device {
	
	private String name;
	private String macAddress;
	
	public Device(String name, String mac) {
		this.name = name;
		this.macAddress = mac;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
}
