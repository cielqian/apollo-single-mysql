package com.cielqian.briefconfig.db;

/**
 * *
 * 数据库初始化程序
 * @author hong.qian
 * @email qianhong@goldwind.com.cn
 * @date 2021/5/15
 */
public interface DbInitializer {

    /**
     * 是否已经初始化
     * @return
     */
    Boolean isInitialized();

    /**
     * 初始化程序
     * @return
     */
    Boolean initialze();
}
