package com.cielqian.briefconfig.spi.helper;

import com.cielqian.briefconfig.PropertySourcesProcessor;
import com.cielqian.briefconfig.spi.BeanRegistrationUtil;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

/**
 * *
 *
 * @author hong.qian
 * @email qianhong@goldwind.com.cn
 * @date 2021/5/15
 */
public class DefaultBeiefConfigRegistrarHelper implements BriefConfigRegistrarHelper{
    private Environment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanRegistrationUtil.registerBeanDefinitionIfNotExists(registry, PropertySourcesProcessor.class.getName(),
                PropertySourcesProcessor.class);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
