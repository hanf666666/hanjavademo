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
        isWeekPassword("mt1234");

    }

    /**
     * »ı√‹¬Î–£—È
     * @param password
     * @return
     */
    public static boolean isWeekPassword(String password) {
        //  ≈‰–¬∞Êµ«¬º¬ﬂº≠£∫
        String realPassword = password;

        boolean isWeekPassword=false;

        if(!isWeekPassword){
            String regEx = "^(?!^\\d+$)(?!^[a-zA-Z!@#$&=.+-]+$)[A-Z0-9a-z!@#$&=.+-]{6,30}$";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(realPassword);
            isWeekPassword=m.matches();
            System.out.println(password+"isWeekPassword:"+isWeekPassword);

        }

        return isWeekPassword;
    }

}
