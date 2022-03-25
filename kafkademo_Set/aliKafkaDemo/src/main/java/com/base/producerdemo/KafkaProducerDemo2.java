package com.base.producerdemo;

/**
 * to do
 *
 *
 *
 * @author Hj
 * @date 2021/8/18
 */

import cn.hutool.core.date.DateUtil;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;

public class KafkaProducerDemo2 {

    public static void main(String args[]) {
        Properties props = new Properties();
        //设置接入点，请通过控制台获取对应Topic的接入点。
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "bigdata-alpha-003.meitianbigdata.local:9092,bigdata-alpha-004.meitianbigdata.local:9092,bigdata-alpha-005.meitianbigdata.local:9092");
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "59.110.226.151:9092");

        //消息队列Kafka版消息的序列化方式。
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        //请求的最长等待时间。
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 30 * 1000);
        //设置客户端内部重试次数。
        props.put(ProducerConfig.RETRIES_CONFIG, 5);
        //设置客户端内部重试间隔。
        props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 3000);
        //构造Producer对象，注意，该对象是线程安全的，一般来说，一个进程内一个Producer对象即可。
        //如果想提高性能，可以多构造几个对象，但不要太多，最好不要超过5个。
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        try {
            //批量获取Future对象可以加快速度,。但注意，批量不要太大。

            for (int i =0; i < 3; i++) {

                //[19587, 19301]
                String uuid= UUID.randomUUID().toString().replaceAll("\\-","");
                final long intime = DateUtil.date().getTime();
                //构造一个消息队列Kafka版消息。
                String topic_REPORT_CAR_IN ="CAR_IN"; //消息所属的Topic，请在控制台申请之后，填写在这里。
                String topic_REPORT_CAR_IN_value = "{ \"extra\": {}, \"items\": [ { \"endDate\": null, \"howLong\": null, \"image\": \"111\", \"moneyPay\": 0, \"no\": \""+uuid+"\", \"parkId\": 19587, \"parkItemName\": \"086805\", \"parkName\": \"遂宁市圣泉路十段\", \"parkNo\": \"4590DE\", \"parkType\": 1, \"payType\": 4, \"phone\": \"13320633552\", \"plateNo\": \"川111111\", \"posUserChineseName\": \"5\", \"posUserId\": 5, \"posUserName\": 6, \"postage\": 7, \"startDate\": 1640966400000, \"status\": 8 } ], \"msgSeqNo\": \"20211223154547046GF1q7m\", \"segNo\": \"423542245\", \"topicName\": \"CAR_IN\" } "; //消息的内容。

                String topic_REPORT_CAR_OUT ="CAR_OUT"; //消息所属的Topic，请在控制台申请之后，填写在这里。
                String REPORT_CAR_OUT_value = "{\"extra\":{},\"items\":[{\"endDate\":1638400223000,\"howLong\":27407000,\"image\":\"fasdfa\",\"moneyPay\":0,\"no\":\""+uuid+"\",\"parkId\":19587,\"parkItemName\":\"089511\",\"parkName\":\"遂宁市紫东街二段\",\"parkNo\":\"4590DE\",\"parkType\":1,\"payType\":2,\"phone\":\"15881912046\",\"plateNo\":\"川111111\",\"posUserChineseName\":3,\"posUserId\":4,\"posUserName\":5,\"postage\":7,\"startDate\":1640966400000,\"status\":2}],\"msgSeqNo\":\"202112022156482385V7TIo\",\"segNo\":\"563563456\",\"topicName\":\"CAR_OUT\"}"; //消息的内容。

                //发送消息，并获得一个Future对象。
                ProducerRecord<String, String> kafkaMessageIn =  new ProducerRecord<String, String>(topic_REPORT_CAR_IN, topic_REPORT_CAR_IN_value);
                ProducerRecord<String, String> kafkaMessageOut =  new ProducerRecord<String, String>(topic_REPORT_CAR_OUT, REPORT_CAR_OUT_value);

                 producer.send(kafkaMessageIn);
                producer.send(kafkaMessageOut);


            }
            producer.flush();
        } catch (Exception e) {
            //客户端内部重试之后，仍然发送失败，业务要应对此类错误。
            System.out.println("error occurred");
            e.printStackTrace();
        }
    }
}
