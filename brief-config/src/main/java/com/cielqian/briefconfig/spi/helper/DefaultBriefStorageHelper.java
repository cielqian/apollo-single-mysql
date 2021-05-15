package com.cielqian.briefconfig.spi.helper;

import com.cielqian.briefconfig.PropertySourcesProcessor;
import com.cielqian.briefconfig.spi.BeanRegistrationUtil;
import org.springframework.core.env.Environment;

/**
 * *
 *
 * @author hong.qian
 * @email qianhong@goldwind.com.cn
 * @date 2021/5/15
 */
public class DefaultBriefStorageHelper implements BriefStorageHelper{
    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }

    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public Boolean init() {
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, PropertySourcesProcessor.class.getName(),
                PropertySourcesProcessor.class);
        return null;
    }
}
