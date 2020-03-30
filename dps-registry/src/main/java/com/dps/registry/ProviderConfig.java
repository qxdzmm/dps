package com.dps.registry;

public class ProviderConfig {

	private String serviceName;
	private String ip;
	private int port;
	private String clusertName;
	private String groupName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getClusertName() {
		return clusertName;
	}

	public void setClusertName(String clusertName) {
		this.clusertName = clusertName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "ProviderConfig [serviceName=" + serviceName + ", ip=" + ip + ", port=" + port + ", clusertName="
				+ clusertName + ", groupName=" + groupName + "]";
	}

}
