package com.xml.hutool;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2023/10/5
 */
@Data
@ToString
public class Question {
    private Integer id;
    private String question="";
    private List<String> answerList=new ArrayList<>();
    private String A="";
    private String B="";
    private String C="";
    private String D="";
    private String E="";

}
