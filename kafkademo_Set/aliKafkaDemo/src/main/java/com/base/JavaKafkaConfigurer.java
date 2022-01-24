package com.base;

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
        //��ȡ�����ļ�kafka.properties�����ݡ�
        Properties kafkaProperties = new Properties();
        try {
            kafkaProperties.load(KafkaProducerDemo.class.getClassLoader().getResourceAsStream("kafka.properties"));
        } catch (Exception e) {
            //û���ص��ļ�������Ҫ�����˳���
            e.printStackTrace();
        }
        properties = kafkaProperties;
        return kafkaProperties;
    }
}
