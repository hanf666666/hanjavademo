package com.it;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * to do
 *
 * @author Hj
 * @date 2021/10/20
 */
public class demo02 {
    public static void main(String[] args) {
        String host="172.17.134.80";
        Integer port=9093;
        System.out.println(TelnetUtils.isHostReachable(host,port));
        System.out.println(TelnetUtils.isHostConnectable(host,port));




    }


}
