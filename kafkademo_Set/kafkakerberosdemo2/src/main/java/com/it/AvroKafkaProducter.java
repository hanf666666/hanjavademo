package com.it;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class AvroKafkaProducter {
    Logger logger = LoggerFactory.getLogger("AvroKafkaProducter");
    public static final String USER_SCHEMA = "{"
            + "\"type\":\"record\","
            + "\"name\":\"es_test02\","
            + "\"fields\":["
            + "  { \"name\":\"id\", \"type\":\"string\" },"
            + "  { \"name\":\"name\", \"type\":\"string\" },"
            + "  { \"name\":\"inserttime\", \"type\":\"string\" }"
            + "]}";


    public static byte[] recordToByte(Schema schema, GenericRecord record) {
        DatumWriter userDatumWriter = new SpecificDatumWriter(schema);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BinaryEncoder binaryEncoder = EncoderFactory.get().directBinaryEncoder(outputStream, null);
        try {
            userDatumWriter.write(record, binaryEncoder);
        } catch (IOException e) {

            // logger.info("record转成byte的发生异常"+e.getMessage());
        }
        return outputStream.toByteArray();
    }


    public static void main(String[] args) throws InterruptedException, IOException {

        String parentpath="/home/zhengjianfeng/hdp-test/";
//        String parentpath="D://ideaspace//javaspace//kafkakerberosdemo2//src//main//resources//hdp-test//";
        System.setProperty("java.security.auth.login.config",parentpath+ "jass.conf");
        System.setProperty("java.security.krb5.conf", parentpath+"krb5.conf");
        Properties props = new Properties();
        props.put("bootstrap.servers", "bigdatahdp-57-134.hadoop.com:6667,bigdatahdp-57-135.hadoop.com:6667,bigdatahdp-57-136.hadoop.com:6667");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        props.put("security.protocol", "SASL_PLAINTEXT");
        props.put("sasl.mechanism", "GSSAPI");
        props.put("sasl.kerberos.service.name", "kafka");
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(USER_SCHEMA);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Encoder e = EncoderFactory.get().binaryEncoder(outputStream, null);
        GenericDatumWriter w = new GenericDatumWriter(schema);
        KafkaProducer<String, byte[]> producer = new KafkaProducer<>(props);
        for (int i = 6; i < 15; i++) {
            GenericData.Record avroRecord = new GenericData.Record(schema);
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            avroRecord.put("id", "test" + i);
            avroRecord.put("name", "zhangsan" + i);
            avroRecord.put("inserttime", time + i);
            System.out.println("-----发送数据--------");
            System.out.println(avroRecord.toString());
            System.out.println("----------------------");
//         byte[] bytes = recordToByte(schema, avroRecord);
            w.write(avroRecord, e);


        }
        e.flush();
        byte[] bytes = outputStream.toByteArray();

        System.out.println(bytes.length);
        ProducerRecord<String, byte[]> record = new ProducerRecord<>("es_test10", bytes);
        producer.send(record);
        Thread.sleep(1000);
        outputStream.close();
        producer.close();
    }
}
