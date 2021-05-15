package com.cielqian.briefconfig.spi.helper;

import com.cielqian.briefconfig.spi.Ordered;
import org.springframework.context.EnvironmentAware;

/**
 * *
 *
 * @author hong.qian
 * @email qianhong@goldwind.com.cn
 * @date 2021/5/15
 */
public interface BriefStorageHelper extends Ordered, EnvironmentAware {
    Boolean init();
}
