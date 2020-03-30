package com.dps.registry;

public class RegistryConfig {

	private String address;

	private int prot;
	
	private boolean register;
	
	private boolean subscribe;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getProt() {
		return prot;
	}

	public void setProt(int prot) {
		this.prot = prot;
	}

	public boolean isRegister() {
		return register;
	}

	public void setRegister(boolean register) {
		this.register = register;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}

}
