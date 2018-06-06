package com.example.dynamic.config.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: Breet
 * @Date: 2018/6/5 15:52
 * @Description:
 */
@Aspect
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);


    @Pointcut("execution( * com.example.dynamic.dao.*.*(..))") //在dao层切换
    public void daoAspect() {
    }

    @Before("daoAspect()")
    public void switchDataSource(JoinPoint point) {
        Boolean isMasterMethod = isMasterMethod(point.getSignature().getName());
        if (!isMasterMethod) {
            DynamicDataSourceContextHolder.useSlaveDataSource();
            logger.info("Switch DataSource to [{}] in Method [{}]",
            DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
        }else{
            DynamicDataSourceContextHolder.useMasterDataSource();
        }
    }

    @After("daoAspect())")
    public void restoreDataSource(JoinPoint point) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
        logger.info("Restore DataSource to [{}] in Method [{}]",
                DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
    }

    private Boolean isMasterMethod(String methodName) {
        if(methodName.startsWith("add")
            || methodName.startsWith("create")
            || methodName.startsWith("save")
            || methodName.startsWith("edit")
            || methodName.startsWith("update")
            || methodName.startsWith("delete")
            || methodName.startsWith("remove")
            || methodName.startsWith("insert")){
            return  true;
        }
        return false;
    }
}
