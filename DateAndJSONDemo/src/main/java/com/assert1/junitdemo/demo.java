package com.assert1.junitdemo;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * to do
 *
 * @author Hj
 * @date 2023/4/1
 */
public class demo {
    public static void main(String[] args) {
        Map map=new HashMap<String,String>();

        Assert.assertNotNull("����teamId����Ϊ��1",map.get("teamId"));
        map.put("teamId","2");

        Assert.assertNotEquals("����teamId����Ϊ��2","2",map.get("teamId"));
        Integer count=2;
        Assert.assertEquals("aaa", java.util.Optional.of(11),count);




    }
}
