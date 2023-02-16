package com.xml;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * to do
 *
 * @author Hj
 * @date 2022/12/22
 */
public class xmlDemo2 {
    public static void main(String[] args) {
        Document xml = XmlUtil.createXml();
        Element ap = xml.createElement("ap");

        System.out.println(xml.toString());
    }
}
