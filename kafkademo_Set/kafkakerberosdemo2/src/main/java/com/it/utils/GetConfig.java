package com.it.utils;

/**
 * to do
 *
 * @author Hj
 * @date 2020/12/29
 */
public class GetConfig {
    public static PropsUtil getConnection()
    {
//        PropsUtil propsUtil = new PropsUtil("testEnv/connection.properties");
        PropsUtil propsUtil = new PropsUtil("productionEnv/connection.properties");
        return propsUtil;
    }
}
