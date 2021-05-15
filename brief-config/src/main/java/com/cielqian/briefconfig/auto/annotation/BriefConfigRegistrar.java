package com.cielqian.briefconfig.auto.annotation;

import com.cielqian.briefconfig.spi.helper.BriefConfigRegistrarHelper;
import com.cielqian.briefconfig.spi.ServiceBootstrap;
import com.cielqian.briefconfig.spi.helper.BriefStorageHelper;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

/**
 * *
 *
 * @author hong.qian
 * @email qianhong@goldwind.com.cn
 * @date 2021/5/15
 */
public class BriefConfigRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private final BriefConfigRegistrarHelper helper = ServiceBootstrap.loadPrimary(BriefConfigRegistrarHelper.class);
    private final BriefStorageHelper storageHelper = ServiceBootstrap.loadPrimary(BriefStorageHelper.class);


    @Override
    public void setEnvironment(Environment environment) {
        helper.setEnvironment(environment);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        storageHelper.init();
        helper.registerBeanDefinitions(annotationMetadata, beanDefinitionRegistry);
    }
}
