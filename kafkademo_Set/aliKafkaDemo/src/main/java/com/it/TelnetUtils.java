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
public class TelnetUtils {
    public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("telnet����ʧ��===>"+host+":"+port);
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("telnet���ӳɹ�===>"+host+":"+port);
        return true;
    }

    public static boolean isHostReachable(String host, Integer timeOut) {
        try {
            final boolean reachable = InetAddress.getByName(host).isReachable(timeOut);
            System.out.println("ping���ӳɹ�===>"+host);
            return reachable;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ping����ʧ��===>"+host);
        return false;
    }
}
