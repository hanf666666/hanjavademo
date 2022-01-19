
package com.meisoo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 * to do
 *
 * @author Hj
 * @date 2021/12/31
 */
@Slf4j
@Component
public class KafkaConsumer {

    //     Ïû·Ñ¼àÌý
    @KafkaListener(topics = {
            KafkaTopicConstant.MEISOO_CAR_IN,
            KafkaTopicConstant.MEISOO_CAR_OUT,
            KafkaTopicConstant.REPORT_CAR_IN,
            KafkaTopicConstant.REPORT_CAR_OUT
    })
    public void onMessage(ConsumerRecord<?, ?> record) {

        System.out.println(record);
    }
}

