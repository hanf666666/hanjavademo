package com.json.hutooljson;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
@Slf4j
public class demo02 {

    /**
     * clientid: "418a9921-95ec7435"
     * �ͻ��˵�Ψһ��ʶ�����������ֲ�ͬ��MQTT�ͻ��ˡ�
     * username: "meitianiot"
     * �ͻ��˵��û��������������֤��
     * ip_address: "10.50.255.13"
     * �ͻ��˵�IP��ַ����ʾ������λ�á�
     * port: 49599
     * �ͻ�������ʱʹ�õĶ˿ںš�
     * node: "emqx@emqx-mqtt-statefulset-0.emqx-mqtt-statefulset-svc.mqtt.svc.cluster.local"
     * EMQX�������Ľڵ����ƣ���ʾ�ͻ������ӵ��ľ��������ʵ����
     * listener: "tcp:default"
     * �ͻ������ӵļ��������ͺ����ƣ�������Ĭ�ϵ�TCP��������
     * ����״̬��ʱ��
     * connected: true
     * ��ʾ�ͻ��˵�ǰ��������״̬��
     * created_at: "2025-06-24T16:55:46.209+08:00"
     * ���Ӵ�����ʱ�䣨UTC+8ʱ������
     * connected_at: "2025-06-24T16:55:46.210+08:00"
     * �ͻ��˳ɹ��������ӵ�ʱ�䣨UTC+8ʱ������
     * keepalive: 5
     * �������ʱ�䣬��λΪ�룬��ʾ�ͻ���ÿ��5�뷢��һ�������Ա������ӡ�
     * is_persistent: false
     * �Ự�Ƿ�־ã��˴�Ϊfalse��ʾ�Ự���ǳ־õģ��Ͽ����Ӻ�Ự���ݲ��ᱣ����
     * clean_start: true
     * ��ʾ�ͻ�������ʱʹ���ˡ�clean start����־�������֮ǰ�ĻỰ״̬�����¿�ʼ��
     * expiry_interval: 0
     * �Ự����ʱ�䣬0��ʾ�Ự�������ڡ�
     * is_bridge: false
     * ��ʾ�ÿͻ��˲����Žӿͻ��ˣ�������������������MQTT������������ͻ��ˣ���
     * mountpoint: null
     * ���ص㣬��������ǰ׺���˴�Ϊnull��ʾδ���á�
     * Э����Ϣ
     * proto_name: "MQTT"
     * ʹ�õ�Э�����ƣ�������MQTTЭ�顣
     * proto_ver: 4
     * MQTTЭ��İ汾�ţ��˴�Ϊ4����ӦMQTT 3.1.1����
     * ��Ϣͳ��
     * ����ͳ��
     * send_cnt: 94656
     * ���͵���Ϣ������
     * send_oct: 285649
     * ���͵����ֽ�����
     * send_pkt: 94656
     * ���͵����ݰ�������
     * send_msg: 0
     * ���͵��ض�������Ϣ������������send_cnt��ͳ�ƿھ���ͬ����
     * send_msg.qos0: 0
     * ���͵�QoS0������Ϣ����������֤�ʹ��
     * send_msg.qos1: 0
     * ���͵�QoS1������Ϣ�����������ʹ�һ�Σ���
     * send_msg.qos2: 0
     * ���͵�QoS2������Ϣ������ȷ���ʹ�һ�Σ���
     * ����ͳ��
     * recv_cnt: 241711
     * ���յ���Ϣ������
     * recv_oct: 270048733
     * ���յ����ֽ�����
     * recv_pkt: 94656
     * ���յ����ݰ�������
     * recv_msg: 48145
     * ���յ��ض�������Ϣ�������˴���ҪΪQoS1��Ϣ����
     * recv_msg.qos0: 0
     * ���յ�QoS0������Ϣ������
     * recv_msg.qos1: 48145
     * ���յ�QoS1������Ϣ������
     * recv_msg.qos2: 0
     * ���յ�QoS2������Ϣ������
     * ������Ϣͳ��
     * ������Ϣ����
     * send_msg.dropped: 0
     * �ܹ��������ķ�����Ϣ������
     * send_msg.dropped.too_large: 0
     * ����Ϣ̫��������ķ�����Ϣ������
     * send_msg.dropped.expired: 0
     * ����Ϣ���ڶ������ķ�����Ϣ������
     * send_msg.dropped.queue_full: 0
     * ����Ϣ�������������ķ�����Ϣ������
     * ������Ϣ����
     * recv_msg.dropped: 0
     * �ܹ��������Ľ�����Ϣ������
     * recv_msg.dropped.await_pubrel_timeout: 0
     * ��ȴ�PUBREL��ʱ��QoS2��Ϣ�����У��������Ľ�����Ϣ������
     * ���������
     * subscriptions_cnt: 13
     * �ͻ��˵�ǰ���ĵ�����������
     * subscriptions_max: "infinity"
     * ������������˴�Ϊ�����ơ�
     * mqueue_max: 1000
     * ��Ϣ���е���󳤶ȡ�
     * mqueue_len: 0
     * ��ǰ��Ϣ���еĳ��ȡ�
     * mqueue_dropped: 0
     * ��Ϣ�����б���������Ϣ������
     * mailbox_len: 0
     * ���䣨��������Ϣ���е���һ�ֱ�ʾ���ĵ�ǰ���ȡ�
     * ���д��� (Inflight)
     * inflight_max: 32
     * �����д��ڴ�С����ʾͬʱ���Դ������Ϣ�������ޡ�
     * inflight_cnt: 0
     * ��ǰ�����е���Ϣ������δ���ȷ�ϵ���Ϣ����
     * awaiting_rel_max: 100
     * �ȴ��ͷŵ������Ϣ������QoS2��Ϣ��أ���
     * awaiting_rel_cnt: 0
     * ��ǰ�ȴ��ͷŵ���Ϣ������
     * ��Դ������
     * heap_size: 2586
     * �ͻ���ʹ�õĶ��ڴ��С����λ�������ֽڣ���
     * enable_authn: true
     * �Ƿ����������֤���˴�Ϊtrue��ʾ��Ҫ��֤�û��������롣
     * reductions: 115675034
     * һ���ڲ������������庬�������EMQX��ʵ����أ���Ҫ�ο�EMQX�ĵ�����
     * @param args
     */
    public static void main(String[] args) {
        FileReader fileReader = new FileReader("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\DateAndJSONDemo\\data3\\data.json");
        String jsonStr = fileReader.readString();
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        JSONArray data = jsonObject.getJSONArray("data");
        Long count = 0L;
        for (int i = 0; i < data.size(); i++) {
            JSONObject jsonObject1 = data.getJSONObject(i);
            String reductions = jsonObject1.getStr("reductions");
            String subscriptions_cnt = jsonObject1.getStr("subscriptions_cnt");
            String recv_msg_qos2 = jsonObject1.getStr("recv_msg.qos2");
            String recv_cnt = jsonObject1.getStr("recv_cnt");
            String send_cnt = jsonObject1.getStr("send_cnt");
            String recv_msg_qos0 = jsonObject1.getStr("recv_msg.qos0");
            String keepalive = jsonObject1.getStr("keepalive");
            String send_msgdroppedtoo_large = jsonObject1.getStr("send_msg.dropped.too_large");
            String recv_oct = jsonObject1.getStr("recv_oct");
            String is_persistent = jsonObject1.getStr("is_persistent");
            String heap_size = jsonObject1.getStr("heap_size");
            String send_msg1 = jsonObject1.getStr("send_msg.dropped.expired");
            String send_msg2 = jsonObject1.getStr("send_msg.qos2");
            String listener = jsonObject1.getStr("listener");
            String send_msg4 = jsonObject1.getStr("send_msg.dropped.queue_full");
            String inflight_max = jsonObject1.getStr("inflight_max");
            String enable_authn = jsonObject1.getStr("enable_authn");
            String created_at = jsonObject1.getStr("created_at");
            String send_pkt = jsonObject1.getStr("send_pkt");
            String recv_msg = jsonObject1.getStr("recv_msg.dropped.await_pubrel_timeout");
            String mqueue_max = jsonObject1.getStr("mqueue_max");
            String inflight_cnt = jsonObject1.getStr("inflight_cnt");
            String mqueue_len = jsonObject1.getStr("mqueue_len");
            String node = jsonObject1.getStr("node");
            String awaiting_rel_max = jsonObject1.getStr("awaiting_rel_max");
            String mqueue_dropped = jsonObject1.getStr("mqueue_dropped");
            String connected = jsonObject1.getStr("connected");
            String proto_ver = jsonObject1.getStr("proto_ver");
            String expiry_interval = jsonObject1.getStr("expiry_interval");
            String connected_at = jsonObject1.getStr("connected_at");
            String awaiting_rel_cnt = jsonObject1.getStr("awaiting_rel_cnt");
            String port = jsonObject1.getStr("port");
            String clientid = jsonObject1.getStr("clientid");
            String send_msg22 = jsonObject1.getStr("send_msg.qos1");
            String proto_name = jsonObject1.getStr("proto_name");
            String recv_msg2 = jsonObject1.getStr("recv_msg");
            String ip_address = jsonObject1.getStr("ip_address");
            String username = jsonObject1.getStr("username");
            String is_bridge = jsonObject1.getStr("is_bridge");
            String mountpoint = jsonObject1.getStr("mountpoint");
            String clean_start = jsonObject1.getStr("clean_start");
            String send_msg222 = jsonObject1.getStr("send_msg.dropped");
            String send_msg2111 = jsonObject1.getStr("send_msg");
            String recv_msg11 = jsonObject1.getStr("recv_msg.qos1");
            String send_oct = jsonObject1.getStr("send_oct");
            String recv_pkt = jsonObject1.getStr("recv_pkt");
            String recv_msgdropped = jsonObject1.getStr("recv_msg.dropped");
            String send_msg333 = jsonObject1.getStr("send_msg.qos0");
            String subscriptions_max = jsonObject1.getStr("subscriptions_max");
            String mailbox_len = jsonObject1.getStr("mailbox_len");
//            if(Long.parseLong(mqueue_max)<100000){
//                log.info("data-->{}-->{}",clientid, mqueue_max);
//
//            }
//            if(Long.parseLong(mqueue_max)>0){
//                log.info("data-->{}-->{}",clientid, mqueue_max);
//
//            }

//            if(Long.parseLong(mqueue_len)>0){
//                log.info("data-->{}-->{}",clientid, mqueue_len);
//
//            }

//            if(Long.parseLong(heap_size)>8000){
//                log.info("data-->{}-->{}",clientid, heap_size);
//
//            }
            System.out.println(clientid);



        }
        log.info("data-->{},{}", data.size(), count);


    }


}
