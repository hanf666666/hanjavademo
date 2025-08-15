package com.http;

import java.util.Arrays;

/**
 * @author Hj
 * @date 2025/8/7
 */
public class aaa {
    public static void main(String[] args) {
        String ss="https://www.meitianiot.com,https://wxsr.meitianiot.com,http://k8sapi.meitianiot.com,http://k8swww.meitianiot.com,http://realdata.meitianiot.com,http://www.meitianiot.com,http://api.meitianiot.com,https://api.meitianiot.com,https//k8swww.meitianiot.com,https://webrtch5.meitianiot.com,https://txwww.meitianiot.com,http://txwww.meitianiot.com";
        Arrays.stream(ss.split(",")).forEach(
                row->{
                    System.out.println(row);
                }
        );
    }
}
