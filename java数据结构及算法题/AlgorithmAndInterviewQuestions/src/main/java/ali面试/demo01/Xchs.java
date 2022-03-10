package ali面试.demo01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * to do
 *1、在薪酬核算系统中，薪资项目之间存在依赖关系。例如：实发合计=应发合计-扣款合计；应发合计=基本工资+月度补贴；扣款合计=缺勤扣款+应扣税金。
 * 实发合计=应发合计-扣款合计  ；应发合计=基本工资+月度补贴；扣款合计=缺勤扣款+应扣税金。
 * 假设它们之间的依赖关系使用二元组存储（如下所示），
 * （ 实发合计 ，应发合计）
 * （ 实发合计 ， 扣款合计 ）
 * （ 应发合计 ， 基本工资 ）
 * （ 应发合计 ， 月度补贴 ）
 * （ 扣款合计 ， 缺勤扣款 ）
 * （ 扣款合计 ， 应扣税金 ）
 * 所有的二元组组成一个数组。请编写一个函数，输入上面的数组，输出正确的项目计算顺序。
 * @author Hj
 * @date 2022/3/8
 */
public class Xchs {
    public static void main(String[] args){
        //输入数组处理
        Scanner sa = new Scanner(System.in);
        ArrayList array = new ArrayList();
        String[] strArray = null;
        String sysStr = null;
        String strTemp1 = null;
        String strTemp2 = null;
//        while(sa.hasNext()){
//            String str = sa.nextLine();//获取一行，截取数据
//            array.add(str);
//        }
        array.add("（ 实发合计 ，应发合计）");
        array.add("（ 实发合计 ， 扣款合计 ）");
        array.add("（ 应发合计 ， 基本工资 ）");
        array.add("（ 应发合计 ， 月度补贴 ）");
        array.add("（ 扣款合计 ， 缺勤扣款 ）");
        array.add("（ 扣款合计 ， 应扣税金 ）");
        for(Object obj:array){
            int num = 1;
            String temp = String.valueOf(obj).trim();
            strArray = temp.substring(1,temp.length()).split(",");
            strTemp1 = strArray[0];
            strTemp2 = strArray[1];
            if("实发合计".equals(strTemp1)){
                if("应发合计".equals(strTemp2)){
                    sysStr += "" + strTemp1 + " = "+strTemp2;
                }else{
                    sysStr += " - "+strTemp2;
                }
            }
            if("应发合计".equals(strTemp1)){
                if("基本工资".equals(strTemp2)){
                    sysStr += "" + strTemp1 + " = "+strTemp2;
                }else{
                    sysStr += " + "+strTemp2;
                }
            }
            if("扣款合计".equals(strTemp1)){
                if("缺勤扣款".equals(strTemp2)){
                    sysStr += "" + strTemp1 + " = "+strTemp2;
                }else{
                    sysStr += " + "+strTemp2;
                }
            }
            num++;
            if(num%2 == 1){
                sysStr += " ; ";
            }
        }
        System.out.println(sysStr);
    }
}
