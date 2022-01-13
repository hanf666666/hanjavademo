package com.Thread;

import java.io.File;
import java.io.FileInputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
public class PrintTest{
    public void printjpg(String getfile,String fensu)
    {
        //构造一个文件选择器，默认为当前目录

        File file = new File(getfile);//获取选择的文件
        //构建打印请求属性集
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        //设置打印格式，因为未确定文件类型，这里选择AUTOSENSE
        DocFlavor flavor = DocFlavor.INPUT_STREAM.GIF;
        //查找所有的可用打印服务
        //PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        //定位默认的打印服务
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        //显示打印对话框
        long j=Integer.parseInt(fensu);
        for(int i=0;i<j;i++)
        {
            try {
                DocPrintJob job = defaultService.createPrintJob(); //创建打印作业
                FileInputStream fis = new FileInputStream(file); //构造待打印的文件流
                DocAttributeSet das = new HashDocAttributeSet();
                Doc doc = new SimpleDoc(fis, flavor, das); //建立打印文件格式
                job.print(doc, pras); //进行文件的打印
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String  args[])
    {
        PrintTest  pic = new PrintTest();
        pic.printjpg("C:\\Users\\Win10\\Desktop\\1641993553.png", "1");
    }
}