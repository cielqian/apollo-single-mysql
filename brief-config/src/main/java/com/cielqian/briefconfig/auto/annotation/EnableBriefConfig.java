package com.cielqian.briefconfig.auto.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * *
 *
 * @author hong.qian
 * @email qianhong@goldwind.com.cn
 * @date 2021/5/15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(BriefConfigRegistrar.class)
public @interface EnableBriefConfig {
}
