package com.it.redisdemo;

import com.it.utils.MongoConnUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * to do
 *
 * @author Hj
 * @date 2021/4/12
 */
public class Main {
    @Test
    public void demo01() {

        System.out.println("===="+1);
        final Jedis jedis = getJedis();
        MongoClient client148 = MongoConnUtils.getMongoClient("admin", "etl", "HMKWSZlJ#418", "10.255.57.148:27017,10.255.57.149:27017,10.255.57.150:27017");
        final BasicDBObject basicDBObject = new BasicDBObject();
        final MongoCursor<Document> iterator = client148.getDatabase("spider")
                .getCollection("qichacha_chongqing_relationship").find(basicDBObject).iterator();
        int count = 0;
        while (iterator.hasNext()) {
            final Document document = iterator.next();
            count++;
            String entname = document.get("entname").toString();
            //判断这家公司是否已经存在
            if (jedis.hexists("companyMap",entname )){
                 int count2 = Integer.parseInt(jedis.hget("companyMap", entname));
                 jedis.hset("companyMap", document.get("entname").toString(), count2+1+"");
                 System.out.println("重复的公司名字==="+entname);
            }else{
                jedis.hset("companyMap", document.get("entname").toString(), "1");
            }

            if (count % 10000 == 0) {
                System.out.println(count+"执行到" + document);
            }

        }

//        final String hget = jedis.hget("han_hset", "name1");
//        System.out.println(hget);
        final Map<String, String> han_hsetMap = jedis.hgetAll("han_hset");
        System.out.println(han_hsetMap.size());

        jedis.close();
    }

    public JedisCluster getJedisCluster() {
        String clusterNodes = "10.255.66.10:26379,10.255.67.10:26379,10.255.69.10:26379";
        int maxIdle = 11;
        int maxWaitMillis = 30000;
        int commandTimeout = 30000;
        int soTimeout = 30000;
        int maxAttempts = 11;
        String authPassword = "zlr1800redis";
        String[] cNodes = clusterNodes.split(",");
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        // 分割出集群节点
        for (String node : cNodes) {
            String[] hp = node.split(":");
            nodes.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        return new JedisCluster(nodes, commandTimeout,
                soTimeout, maxAttempts,
                authPassword, jedisPoolConfig);
    }


    /**
     * 单节点访问方式
     *
     * @return
     */
    public Jedis getJedis() {
        String ip = "192.168.34.126";
        int port = 6379;
        String authPassword = "123456";
        // 创建集群对象
        final Jedis jedis = new Jedis(ip, port);
        jedis.auth(authPassword);
        return jedis;
    }
}
