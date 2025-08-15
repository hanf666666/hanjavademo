package com.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

public class KafkaConsumerDemo {

    public static void main(String args[]) {
        //����kafka.properties��
        Properties kafkaProperties =  JavaKafkaConfigurer.getKafkaProperties();

        Properties props = new Properties();
        //���ý���㣬��ͨ������̨��ȡ��ӦTopic�Ľ���㡣
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getProperty("bootstrap.servers"));
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.50.254.127:9092");
        //����Poll֮��������������
        //�����߳�����ֵû�з���������������ж������ߴ��ڷǴ��״̬������˽������ߴ�Consumer Group�Ƴ�������Rebalance��Ĭ��30s��
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 300000);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 300000);
        //ÿ��Poll�����������
        //ע���ֵ��Ҫ�ĵ�̫�����Poll̫�����ݣ����������´�Poll֮ǰ�����꣬��ᴥ��һ�θ��ؾ��⣬�������١�
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 300);
        //��Ϣ�ķ����л���ʽ��
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        //��ǰ����ʵ�������������飬���ڿ���̨����֮����д��
        //����ͬһ���������ʵ�����Ḻ��������Ϣ��
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getProperty("group.id"));
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getProperty("group.id"));
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //�������Ѷ���Ҳ������һ������ʵ����
        KafkaConsumer<String, String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<String, String>(props);

        //���������鶩�ĵ�Topic�����Զ��Ķ����
        //���GROUP_ID_CONFIG��һ�������ĵ�TopicҲ�������ó�һ����
        List<String> subscribedTopics =  new ArrayList<String>();
        //�����Ҫ���Ķ��Topic������������ӽ�ȥ���ɡ�
        //ÿ��Topic��Ҫ���ڿ���̨���д�����
        String topicStr = kafkaProperties.getProperty("topic");
        String[] topics = topicStr.split(",");
        for (String topic: topics) {
            subscribedTopics.add(topic.trim());
        }
        consumer.subscribe(subscribedTopics);
        int count=0;
        //ѭ��������Ϣ��
        while (true){
            try {
                count++;
                ConsumerRecords<String, String> records = consumer.poll(1000);
                //�������´�Poll֮ǰ��������Щ����, ���ܺ�ʱ���ó���SESSION_TIMEOUT_MS_CONFIG��
                //���鿪һ���������̳߳���������Ϣ��Ȼ���첽���ؽ����

                System.out.println(count+"===================================>record"+records.count());
                try {
//                    Thread.sleep(90000);
                } catch (Throwable ignore) {

                }
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(count+++"==>"+String.format("Consume partition:%d offset:%d,message:%s",
                            record.partition(),
                            record.offset(),
                            record.value()

                    )
                    );


                }
                System.out.println("<===================================");
            } catch (Exception e) {
                try {
                    Thread.sleep(1000);
                } catch (Throwable ignore) {

                }
                e.printStackTrace();
            }
        }
    }
}
