package com.xml;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;

/**
 * to do
 *
 * @author Hj
 * @date 2022/12/22
 */
public class xmlDemo3 {
    public static void main(String[] args) {
        Document document = XmlUtil.parseXml(getXmlInfo());

        System.out.println(XmlUtil.getByXPath("//ap/head/tr_code",document, XPathConstants.STRING));

        System.out.println( XmlUtil.toStr(document));
        NodeList tr_codeNodeList = document.getElementsByTagName("tr_code");
        Node node = tr_codeNodeList.item(0);
        System.out.println(node.getNodeName());
        System.out.println(node.getNodeValue());
        System.out.println(node.getTextContent());

        System.out.println( XmlUtil.toStr(document));
    }


    private static String getXmlInfo() {
        StringBuilder sb = new StringBuilder();
//        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<ap>");
        sb.append(" <head>");
        sb.append("         <tr_code>210201</tr_code>");
        //企业代码
        sb.append("         <corp_no>0009999842</corp_no>");
        //00003 用户号
        sb.append("         <user_no>00003</user_no>");
//        sb.append("         <req_no>00010239</req_no>");
        //交易时间
        sb.append("         <tr_acdt>20221223</tr_acdt>");
        sb.append("         <tr_time>150108</tr_time>");
        //原子交易数
        sb.append("        <atom_tr_count>1</atom_tr_count>");
        //交易渠道
        sb.append("        <channel>0</channel>");
        sb.append("        <reserved></reserved>");
        sb.append(" </head>");
        sb.append(" <body>");
        //付 款 人 账 号
        sb.append("         <pay_acno>310069037013004296362</pay_acno>");
        sb.append("         <pay_acname>上海黄浦江科技技术有限公司</pay_acname>");
        //收款人
        sb.append("         <rcv_acno>310069079018010019570</rcv_acno>");
        sb.append("         <rcv_bank_name>测试账号 2</rcv_bank_name>");
//        sb.append("         <rcv_acname>业务测试有限公司43097</rcv_acname>");

        sb.append("         <cur_code>CNY</cur_code>");
        sb.append("         <amt>14.22</amt>");
        //企业凭证编号
        sb.append("         <cert_no>104841212NG1</cert_no>");
        sb.append("         <bank_flag>0</bank_flag>");
        sb.append(" </body>");
        sb.append("</ap>");

        //
        //洁空季和顺,??6222620110076082818?
        //则晓枫洁,???6222620110075941360?
        return sb.toString();
    }
}
