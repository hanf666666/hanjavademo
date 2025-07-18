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
     * 客户端的唯一标识符，用于区分不同的MQTT客户端。
     * username: "meitianiot"
     * 客户端的用户名，用于身份验证。
     * ip_address: "10.50.255.13"
     * 客户端的IP地址，表示其网络位置。
     * port: 49599
     * 客户端连接时使用的端口号。
     * node: "emqx@emqx-mqtt-statefulset-0.emqx-mqtt-statefulset-svc.mqtt.svc.cluster.local"
     * EMQX服务器的节点名称，表示客户端连接到的具体服务器实例。
     * listener: "tcp:default"
     * 客户端连接的监听器类型和名称，这里是默认的TCP监听器。
     * 连接状态与时间
     * connected: true
     * 表示客户端当前处于连接状态。
     * created_at: "2025-06-24T16:55:46.209+08:00"
     * 连接创建的时间（UTC+8时区）。
     * connected_at: "2025-06-24T16:55:46.210+08:00"
     * 客户端成功建立连接的时间（UTC+8时区）。
     * keepalive: 5
     * 心跳间隔时间，单位为秒，表示客户端每隔5秒发送一次心跳以保持连接。
     * is_persistent: false
     * 会话是否持久，此处为false表示会话不是持久的，断开连接后会话数据不会保留。
     * clean_start: true
     * 表示客户端连接时使用了“clean start”标志，会清除之前的会话状态，重新开始。
     * expiry_interval: 0
     * 会话过期时间，0表示会话永不过期。
     * is_bridge: false
     * 表示该客户端不是桥接客户端（即不是用于连接两个MQTT服务器的特殊客户端）。
     * mountpoint: null
     * 挂载点，用于主题前缀，此处为null表示未设置。
     * 协议信息
     * proto_name: "MQTT"
     * 使用的协议名称，这里是MQTT协议。
     * proto_ver: 4
     * MQTT协议的版本号，此处为4（对应MQTT 3.1.1）。
     * 消息统计
     * 发送统计
     * send_cnt: 94656
     * 发送的消息总数。
     * send_oct: 285649
     * 发送的总字节数。
     * send_pkt: 94656
     * 发送的数据包总数。
     * send_msg: 0
     * 发送的特定类型消息总数（可能与send_cnt的统计口径不同）。
     * send_msg.qos0: 0
     * 发送的QoS0级别消息数量（不保证送达）。
     * send_msg.qos1: 0
     * 发送的QoS1级别消息数量（至少送达一次）。
     * send_msg.qos2: 0
     * 发送的QoS2级别消息数量（确保送达一次）。
     * 接收统计
     * recv_cnt: 241711
     * 接收的消息总数。
     * recv_oct: 270048733
     * 接收的总字节数。
     * recv_pkt: 94656
     * 接收的数据包总数。
     * recv_msg: 48145
     * 接收的特定类型消息总数（此处主要为QoS1消息）。
     * recv_msg.qos0: 0
     * 接收的QoS0级别消息数量。
     * recv_msg.qos1: 48145
     * 接收的QoS1级别消息数量。
     * recv_msg.qos2: 0
     * 接收的QoS2级别消息数量。
     * 丢弃消息统计
     * 发送消息丢弃
     * send_msg.dropped: 0
     * 总共被丢弃的发送消息数量。
     * send_msg.dropped.too_large: 0
     * 因消息太大而丢弃的发送消息数量。
     * send_msg.dropped.expired: 0
     * 因消息过期而丢弃的发送消息数量。
     * send_msg.dropped.queue_full: 0
     * 因消息队列满而丢弃的发送消息数量。
     * 接收消息丢弃
     * recv_msg.dropped: 0
     * 总共被丢弃的接收消息数量。
     * recv_msg.dropped.await_pubrel_timeout: 0
     * 因等待PUBREL超时（QoS2消息处理中）而丢弃的接收消息数量。
     * 订阅与队列
     * subscriptions_cnt: 13
     * 客户端当前订阅的主题数量。
     * subscriptions_max: "infinity"
     * 最大订阅数量，此处为无限制。
     * mqueue_max: 1000
     * 消息队列的最大长度。
     * mqueue_len: 0
     * 当前消息队列的长度。
     * mqueue_dropped: 0
     * 消息队列中被丢弃的消息数量。
     * mailbox_len: 0
     * 邮箱（可能是消息队列的另一种表示）的当前长度。
     * 飞行窗口 (Inflight)
     * inflight_max: 32
     * 最大飞行窗口大小，表示同时可以处理的消息数量上限。
     * inflight_cnt: 0
     * 当前飞行中的消息数量（未完成确认的消息）。
     * awaiting_rel_max: 100
     * 等待释放的最大消息数量（QoS2消息相关）。
     * awaiting_rel_cnt: 0
     * 当前等待释放的消息数量。
     * 资源与配置
     * heap_size: 2586
     * 客户端使用的堆内存大小（单位可能是字节）。
     * enable_authn: true
     * 是否启用身份验证，此处为true表示需要验证用户名和密码。
     * reductions: 115675034
     * 一个内部计数器，具体含义可能与EMQX的实现相关（需要参考EMQX文档）。
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
