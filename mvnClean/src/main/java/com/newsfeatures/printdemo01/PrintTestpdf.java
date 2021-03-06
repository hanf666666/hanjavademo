package com.newsfeatures.printdemo01;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Sides;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PrintTestpdf {
    public static void main(String[] args) {
        //1.得到一个文件的输入流
        FileInputStream fiStream = null;
        try {
            String newfile = "C:\\Users\\Win10\\Desktop\\aa.pdf";
            fiStream = new FileInputStream(newfile);
        } catch (FileNotFoundException ffne) {
        }


//这是要打印文件的格式，如果是PDF文档要设为自动识别
        DocFlavor fileFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
//2.得到要打印的文档类DOC
        Doc myDoc = new SimpleDoc(fiStream, fileFormat, null);
//3.生成一个打印属性设置对象
        PrintRequestAttributeSet aset =
                new HashPrintRequestAttributeSet();
        aset.add(new Copies(1));//Copies-打印份数5份
//        aset.add(MediaSize.getMediaSizeForName(MediaSizeName.ISO_A4));//A4纸张
        aset.add(Sides.DUPLEX);//双面打印
//4.关键一步，得到当前机器上所有已经安装的打印机
//传入的参数是文档格式跟打印属性，只有支持这个格式与属性的打印机才会被找到
        PrintService[] services =
                PrintServiceLookup.lookupPrintServices(fileFormat, aset);
        if (services.length > 0) {
            //5.用打印服务生成一个文档打印任务，这里用的是第一个服务
            //也可以进行筛选，services[i].getName()可以得到打印机名称，可用名称进行比较得到自己想要的打印机
            DocPrintJob job = services[0].createPrintJob();
            try {
                //6.最后一步，执行打印文档任务，传入的参数是Doc文档类，与属性(5份，双面,A4)
                job.print(myDoc, aset);//成功后电脑会提示已有文档添加到打印队列
            } catch (PrintException pe) {
            }
        }
    }

}