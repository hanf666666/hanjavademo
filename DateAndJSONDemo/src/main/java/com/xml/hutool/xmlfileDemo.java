package com.xml.hutool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * to do
 *
 * @author Hj
 * @date 2022/12/22
 */

public class xmlfileDemo {
    public static void main(String[] args) {


        File file = new File("D:\\ideaspace\\ScheduleWorkflow202308.xml");
        Document document = XmlUtil.readXML(file);
        NodeList nodeList = document.getElementsByTagName("row");
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <nodeList.getLength() ; i++) {
            Node item = nodeList.item(i);
            String id = XmlUtil.getByXPath("id", item, XPathConstants.STRING).toString();
            String name = XmlUtil.getByXPath("name", item, XPathConstants.STRING).toString();
            String beginTime = XmlUtil.getByXPath("beginTime", item, XPathConstants.STRING).toString();
            String endTime = XmlUtil.getByXPath("endTime", item, XPathConstants.STRING).toString();
            String reason = XmlUtil.getByXPath("reason", item, XPathConstants.STRING).toString();
            String workflowType = XmlUtil.getByXPath("workflowType", item, XPathConstants.STRING).toString();
            if(name.contains("韩静")){
//                System.out.println();
                int i1 = DateUtil.dayOfWeek(DateUtil.parse(beginTime));
                strings.add(workflowType+name+":"+DateUtil.parse(beginTime)+"到"+DateUtil.parse(endTime)+"星期"+(i1-1)+" 原因:"+reason);
            }
        }
         strings.stream().sorted().forEach(row->{
             System.out.println(row);
        });

    }


}
