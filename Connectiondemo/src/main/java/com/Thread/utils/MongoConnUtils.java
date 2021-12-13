package com.Thread.utils;

import com.mongodb.*;
import com.mongodb.client.MongoCursor;
import org.bson.BSONObject;
import org.bson.Document;

import java.util.ArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2021/4/12
 */
public class MongoConnUtils {

    /**
     * @param authdb
     * @param mongo_user
     * @param password
     * @param hosts      ip:端口,ip:端口
     * @return
     */
    public static MongoClient getMongoClient(String authdb, String mongo_user, String password, String hosts) {
        final String[] ipPortArr = hosts.split(",");

        ArrayList serverAddrList = new ArrayList<ServerAddress>();
        for (int i = 0; i < ipPortArr.length; i++) {
            serverAddrList.add(new ServerAddress(ipPortArr[i].split(":")[0], Integer.parseInt(ipPortArr[i].split(":")[1])));
        }

        //        String credential = new util.ArrayList[MongoCredential]
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(mongo_user, authdb, password.toCharArray());
        //        credential.add(mongoCredential)
        final MongoClientOptions options = MongoClientOptions.builder()
                .connectTimeout(1000 * 60 * 100)
                .socketTimeout(1000 * 60 * 1000)
                .maxWaitTime(1000 * 60 * 100)
                //          .connectionsPerHost(1000)
                //          .minConnectionsPerHost(100)
                .build();

        final MongoClient mongoClient = new MongoClient(serverAddrList, mongoCredential, options);
        return mongoClient;


    }

    public static void main(String[] args) {
        MongoClient client148 = MongoConnUtils.getMongoClient("admin", "etl", "HMKWSZlJ#418", "10.255.57.148:27017,10.255.57.149:27017,10.255.57.150:27017");
        final BasicDBObject basicDBObject = new BasicDBObject();
        final MongoCursor<Document> iterator = client148.getDatabase("spider")
                .getCollection("qichacha_chongqing_relationship").find(basicDBObject).iterator();
        while (iterator.hasNext()){
            final Document next = iterator.next();
            System.out.println(next);
        }

    }

}
