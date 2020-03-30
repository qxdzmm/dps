package com.dps.registry;

import java.util.List;

public interface Registry {

	/**
	 * 初始化
	 */
	public void init(RegistryConfig config) throws Exception;

	/**
	 * 生产者注册
	 * 
	 * @param config
	 */
	public void register(ProviderConfig config);

	/**
	 * 生产者下线
	 * 
	 * @param config
	 */
	public void unRegister(ProviderConfig config);

	/**
	 * 生产者批量下线
	 * 
	 * @param configs
	 */
	public void batchUnRegister(List<ProviderConfig> configs);

	/**
	 * 消费者批量下线
	 * 
	 * @param configs
	 */
	public void batchUnSubscribe(List<ConsumerConfig> configs);

	/**
	 * 消费者注册
	 * 
	 * @param config
	 * @return
	 */
	public List<ProviderGroup> subscribe(final ConsumerConfig config);

	/**
	 * 消费者下线
	 * 
	 * @param config
	 */
	public void unSubscribe(ConsumerConfig config);
	
	/**
	 * 根据客户端信息查找所有符合提交的服务端信息
	 * @param config
	 * @return
	 */
	public List<ServiceInstance> selectAllInstance(final ConsumerConfig config);

	/**
	 * 销毁
	 */
	public void destroy(RegistryConfig config);

}
