package com.json.hutooljson.strToBean;

import cn.hutool.core.date.DateUtil;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/13
 */
public class demo03 {

    public static void main(String[] args) {

//        String jsonStr="{\n" +
//                "  \"name\": \"hanjing\",\n" +
//                "  \"curDateTime\": \"2022-01-01T00:00:00.000\"\n" +
//                "}";
        // DateUtil.parse(value)
        String jsonStr="[{\"val\":8,\"name\":\"����\",\"ab\":\"����\",\"bgColor\":\"#ff00ff\",\"ftColor\":\"#000000\",\"priority\":1,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":64,\"name\":\"������\",\"ab\":\"������\",\"bgColor\":\"#ffff00\",\"ftColor\":\"#000000\",\"priority\":2,\"type\":0,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":256,\"name\":\"������\",\"ab\":\"������\",\"bgColor\":\"#ffff00\",\"ftColor\":\"#000000\",\"priority\":3,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":1024,\"name\":\"������\",\"ab\":\"������\",\"bgColor\":\"#ffff00\",\"ftColor\":\"#000000\",\"priority\":4,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":2048,\"name\":\"����\",\"ab\":\"����\",\"bgColor\":\"#ff00ff\",\"ftColor\":\"#000000\",\"priority\":5,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":16777216,\"name\":\"����\",\"ab\":\"����\",\"bgColor\":\"#ff00ff\",\"ftColor\":\"#000000\",\"priority\":5,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":131072,\"name\":\"������\",\"ab\":\"������\",\"bgColor\":\"#ffff00\",\"ftColor\":\"#000000\",\"priority\":6,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":262146,\"name\":\"δ��\",\"ab\":\"����\",\"bgColor\":\"#00ff00\",\"ftColor\":\"#000000\",\"priority\":7,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":262150,\"name\":\"δ��\",\"ab\":\"����\",\"bgColor\":\"#00ff00\",\"ftColor\":\"#000000\",\"priority\":8,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":524292,\"name\":\"δ��\",\"ab\":\"����\",\"bgColor\":\"#00ff00\",\"ftColor\":\"#000000\",\"priority\":10,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":655364,\"name\":\"������\",\"ab\":\"������\",\"bgColor\":\"#ffff00\",\"ftColor\":\"#000000\",\"priority\":11,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":2097152,\"name\":\"����\",\"ab\":\"����\",\"bgColor\":\"#ff00ff\",\"ftColor\":\"#000000\",\"priority\":12,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":2621444,\"name\":\"����\",\"ab\":\"����\",\"bgColor\":\"#ff00ff\",\"ftColor\":\"#000000\",\"priority\":13,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":20176833,\"name\":\"������\",\"ab\":\"������\",\"bgColor\":\"#ffff00\",\"ftColor\":\"#000000\",\"priority\":14,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":17301508,\"name\":\"����\",\"ab\":\"����\",\"bgColor\":\"#ff00ff\",\"ftColor\":\"#000000\",\"priority\":15,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0},{\"val\":393219,\"name\":\"������\",\"ab\":\"������\",\"bgColor\":\"#ffff00\",\"ftColor\":\"#000000\",\"priority\":16,\"type\":1,\"alarmType\":1,\"showType\":0,\"parentType\":0,\"treeLevel\":0}]";


        System.out.println(jsonStr);
    }
}
