package com.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * to do
 *
 * @author Hj
 * @date 2024/6/11
 */
public class OtherDemo01 {
    public static void main(String[] args) {
//        isWeekPassword("mt12345");
//        isWeekPassword("aaa12345adfa1111");
        isWeekPassword("1111");
        isWeekPassword("asdfa");

    }

    /**
     * 弱密码校验
     * @param password
     * @return
     */
    public static boolean isWeekPassword(String password) {
        //适配新版登录逻辑：
        String realPassword = password;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(realPassword);
        while (matcher.find()) {
            realPassword = matcher.group();
            System.out.println(realPassword);

        }


        boolean isWeekPassword=false;


        if(!isWeekPassword){
            //匹配4位顺降或匹配4位顺降
            String regEx = "(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){4,}|" +
                    "(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){4,})\\d";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(realPassword);
            isWeekPassword=m.matches();
            System.out.println(password+"匹配4位顺降或匹配4位顺降isWeekPassword:"+isWeekPassword);
        }
        if(!isWeekPassword){
            //匹配3位以上的重复数字
            String regEx = "([\\d])\\1{3,}";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(realPassword);
            isWeekPassword=m.matches();
            System.out.println(realPassword+"匹配3位以上的重复数字isWeekPassword:"+isWeekPassword);
        }


        return isWeekPassword;
    }

}
