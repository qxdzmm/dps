package com.dps.registry.nacos;

import java.util.List;
import java.util.Properties;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.dps.common.utils.DpsRegistryException;
import com.dps.common.utils.StringUtils;
import com.dps.registry.ConsumerConfig;
import com.dps.registry.ProviderConfig;
import com.dps.registry.ProviderGroup;
import com.dps.registry.Registry;
import com.dps.registry.RegistryConfig;
import com.dps.registry.ServiceInstance;

public class NacosRegistry implements Registry {

	private NamingService namingService;

	private Properties nacosProperties = new Properties();

	private static final String SERVER_ADDR = "serverAddr";
	private static final String NAMESPACE = "namespace";

	@Override
	public void init(RegistryConfig config) throws DpsRegistryException {
		if (namingService != null) {
			return;
		}
		String addressInput = config.getAddress(); // xxx:8848,yyy:8848/namespace nacos的注册形式
		if (StringUtils.isEmpty(addressInput)) {
			throw new DpsRegistryException("Address of nacos registry is empty.");
		}
		int ipCount = 0;
		String address = "";
		String namespace = "";
		nacosProperties.put(SERVER_ADDR, address);
		nacosProperties.put(NAMESPACE, namespace);
		try {
			namingService = NamingFactory.createNamingService(nacosProperties);
		} catch (NacosException e) {

		}
	}

	@Override
	public void register(ProviderConfig config) {
		if (namingService == null) {
			return;
		}
		try {
			// 注册一些基本信息就可以了，不需要一些元数据信息
			namingService.registerInstance(config.getServiceName(), config.getGroupName(), config.getIp(),
					config.getPort(), config.getClusertName());
		} catch (NacosException e) {
			// TODO 注册失败的时候，怎么处理？？？
		}

	}

	@Override
	public void unRegister(ProviderConfig config) {
		if (namingService == null) {
			return;
		}
		try {
			namingService.deregisterInstance(config.getServiceName(), config.getGroupName(), config.getIp(),
					config.getPort(), config.getClusertName());
		} catch (NacosException e) {
			// TODO 注册失败的时候，怎么处理？？？
		}
	}

	@Override
	public void batchUnRegister(List<ProviderConfig> configs) {

	}

	@Override
	public void batchUnSubscribe(List<ConsumerConfig> configs) {

	}

	@Override
	public List<ProviderGroup> subscribe(ConsumerConfig config) {
		if (namingService == null) {
			return null;
		}
		try {
			namingService.subscribe(config.getServiceName(), config.getGroupName(), config.getClusters(),
					new DpsEventListener());
		} catch (NacosException e) {

		}
		return null;
	}

	@Override
	public void unSubscribe(ConsumerConfig config) {
		if (namingService == null) {
			return;
		}
		try {
			namingService.unsubscribe(config.getServiceName(), config.getGroupName(), config.getClusters(),
					new DpsEventListener());
		} catch (NacosException e) {
		}
	}

	@Override
	public List<ServiceInstance> selectAllInstance(ConsumerConfig config) {
		if (namingService == null) {
			return null;
		}
		try {
			List<Instance> instances = namingService.selectInstances(config.getServiceName(), config.getGroupName(), config.getClusters(), true, true);
			instances.forEach(instance->{
				
			});
		} catch (NacosException e) {
			
		}
		return null;
	}

	@Override
	public void destroy(RegistryConfig config) {

	}

}
