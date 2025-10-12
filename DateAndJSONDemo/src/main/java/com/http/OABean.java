package com.http;

import lombok.Data;
import lombok.ToString;

/**
 * to do
 *
 * @author Hj
 * @date 2024/6/25
 */
@Data
@ToString
public class OABean {
    //"subcompanyid":"20",
    private String subcompanyid;
    // "subcompanyname":"盘古美天",
    private String subcompanyname;
    // "departmentid":"213",
    private String departmentid;
    // "departmentname":"大数据部",
    private String departmentname;
    // "hrmid":"1378",
    private String hrmid;
    // "hrmname":"韩静",
    private String hrmname;
    // "scheduledate":"2025-10-01",
    private String scheduledate;
    // "scheduleweek":"星期三",
    private String scheduleweek;
    // "scheduletype":"节假日",
    private String scheduletype;
    // "timeslot":"---",
    private String timeslot;
    // "beginsigntime":"---",
    private String beginsigntime;
    // "endsigntime":"---",
    private String endsigntime;
    // "kqrequest":"",
    private String kqrequest;
    // "auditstatus":"正常"
    private String auditstatus;
}
