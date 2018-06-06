package com.example.dynamic.config.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: Breet
 * @Date: 2018/6/5 14:46
 * @Description:
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);
    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("当前数据源：{}"+ DynamicDataSourceContextHolder.getDataSourceKey());
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }
}
