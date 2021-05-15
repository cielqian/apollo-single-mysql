package com.cielqian.briefconfig.spi.helper;

import com.cielqian.briefconfig.spi.Ordered;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.type.AnnotationMetadata;

/**
 * *
 *
 * @author hong.qian
 * @email qianhong@goldwind.com.cn
 * @date 2021/5/15
 */
public interface BriefConfigRegistrarHelper extends Ordered, EnvironmentAware {
    void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry);
}
