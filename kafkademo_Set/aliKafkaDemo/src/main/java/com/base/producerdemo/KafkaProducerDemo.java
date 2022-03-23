package com.base.producerdemo;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/18
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;

import com.base.JavaKafkaConfigurer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaProducerDemo {

    public static void main(String args[]) {
        //����kafka.properties��
        Properties kafkaProperties =  JavaKafkaConfigurer.getKafkaProperties();

        Properties props = new Properties();
        //���ý���㣬��ͨ������̨��ȡ��ӦTopic�Ľ���㡣
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getProperty("bootstrap.servers"));

        //��Ϣ����Kafka����Ϣ�����л���ʽ��
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        //�������ȴ�ʱ�䡣
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 30 * 1000);
        //���ÿͻ����ڲ����Դ�����
        props.put(ProducerConfig.RETRIES_CONFIG, 5);
        //���ÿͻ����ڲ����Լ����
        props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 3000);
        //����Producer����ע�⣬�ö������̰߳�ȫ�ģ�һ����˵��һ��������һ��Producer���󼴿ɡ�
        //�����������ܣ����Զ๹�켸�����󣬵���Ҫ̫�࣬��ò�Ҫ����5����
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        //����һ����Ϣ����Kafka����Ϣ��
        String topic = kafkaProperties.getProperty("topic"); //��Ϣ������Topic�����ڿ���̨����֮����д�����
        String value = "this is the message's value"; //��Ϣ�����ݡ�

        try {
            //������ȡFuture������Լӿ��ٶ�,����ע�⣬������Ҫ̫��
            List<Future<RecordMetadata>> futureArrayList = new ArrayList<Future<RecordMetadata>>(3);
            for (int i =0; i < 1000; i++) {
                //������Ϣ�������һ��Future����
                ProducerRecord<String, String> kafkaMessage =  new ProducerRecord<String, String>(topic, value + ": " + i);
                System.out.println("������Ϣ===>"+value + ": " + i);
                Future<RecordMetadata> metadataFuture = producer.send(kafkaMessage);
                futureArrayList.add(metadataFuture);

            }
            producer.flush();
            for (Future<RecordMetadata> future: futureArrayList) {
                //ͬ�����Future����Ľ����
                try {
                    RecordMetadata recordMetadata = future.get();
                    System.out.println("Produce ok=====>:" + recordMetadata.toString());
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        } catch (Exception e) {
            //�ͻ����ڲ�����֮����Ȼ����ʧ�ܣ�ҵ��ҪӦ�Դ������
            System.out.println("error occurred");
            e.printStackTrace();
        }
    }
}
