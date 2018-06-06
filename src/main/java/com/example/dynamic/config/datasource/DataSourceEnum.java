package com.example.dynamic.config.datasource;

/**
 * 数据源枚举
 * @author wangzhiqiang
 * @date 2018年5月08日 
 */
public enum DataSourceEnum {
	
	Master{public String value() {return "master";}},
	
	Slave{public String value() {return "slave";}};
	
	public abstract String value();
	
}
