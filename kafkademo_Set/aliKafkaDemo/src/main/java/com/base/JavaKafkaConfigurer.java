package com.base;

import com.base.producerdemo.KafkaProducerDemo;

import java.util.Properties;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/18
 */
public class JavaKafkaConfigurer {
    private static Properties properties;
    public synchronized static Properties getKafkaProperties() {
        if (null != properties) {
            return properties;
        }
        //获取配置文件kafka.properties的内容。
        Properties kafkaProperties = new Properties();
        try {
            kafkaProperties.load(KafkaProducerDemo.class.getClassLoader().getResourceAsStream("kafka.properties"));
        } catch (Exception e) {
            //没加载到文件，程序要考虑退出。
            e.printStackTrace();
        }
        properties = kafkaProperties;
        return kafkaProperties;
    }
}
