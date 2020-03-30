package com.dps.registry;

import java.util.List;

public class ConsumerConfig {

	private String serviceName;
	private String groupName;
	private List<String> clusters;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<String> getClusters() {
		return clusters;
	}

	public void setClusters(List<String> clusters) {
		this.clusters = clusters;
	}

}
