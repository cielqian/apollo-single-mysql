package com.cielqian.briefconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * *
 *
 * @author hong.qian
 * @email qianhong@goldwind.com.cn
 * @date 2021/5/15
 */

@Component
public class PropertySourcesProcessor implements BeanFactoryPostProcessor, EnvironmentAware, PriorityOrdered {
    private ConfigurableEnvironment environment;


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        initializePropertySources();
    }

    private void initializePropertySources() {
        if (environment.getPropertySources().contains(PropertySourcesConstants.BRIEF_PROPERTY_SOURCE_NAME)) {
            return;
        }
        //TODO: load all config from db、 properties 、yuml
        Map propertiesMap = new HashMap();

        EnumerablePropertySource amPropertySource = new MapPropertySource(PropertySourcesConstants.BRIEF_PROPERTY_SOURCE_NAME, propertiesMap);


        environment.getPropertySources().addFirst(amPropertySource);
    }

    private void initializePropertyAutoUpdate(ConfigurableListableBeanFactory beanFactory){
        //do nothing
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment)environment;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}

