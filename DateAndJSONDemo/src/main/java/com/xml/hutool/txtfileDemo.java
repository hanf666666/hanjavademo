package com.xml.hutool;

import cn.hutool.core.io.resource.ResourceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * to do
 *
 * @author Hj
 * @date 2022/12/22
 */

public class txtfileDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader utf8Reader = ResourceUtil.getUtf8Reader("D:\\ideaspace\\aaaa.sql");
        HashMap<Integer, Question> questionHashMap = new HashMap<>();
        final Integer[] count = {1};
        utf8Reader.lines().forEach(row -> {
                    if (row.contains("第") && row.contains("页")) {

                    } else {
                        if (count[0].toString().equals(row.split(" ")[0])) {
                            //问题
                            Question question = new Question();
                            question.setQuestion(row);
                            question.setId(count[0]);
                            questionHashMap.put(count[0], question);
                            count[0]++;
                        } else {
                            //选项
                            if (row.contains("A．")) {
                                questionHashMap.get((count[0] - 1)).setA(row);
                            } else if (row.contains("B．")) {
                                questionHashMap.get((count[0] - 1)).setB(row);
                            } else if ((row.contains("C．"))) {
                                questionHashMap.get((count[0] - 1)).setC(row);
                            } else if (row.contains("D．")) {
                                questionHashMap.get((count[0] - 1)).setD(row);
                            } else if (row.contains("E．")) {
                                questionHashMap.get((count[0] - 1)).setE(row);
                            } else {
                                //问题
                                Question question = questionHashMap.get((count[0] - 1));
                                question.setQuestion(question.getQuestion() + row);
                            }
                        }
                        //答案
                        if ((row.contains("A") && !row.contains("A．"))) {
                            questionHashMap.get((count[0] - 1)).getAnswerList().add("A");
                        } else if ((row.contains("B") && !row.contains("B．"))) {
                            questionHashMap.get((count[0] - 1)).getAnswerList().add("B");
                        } else if ((row.contains("C") && !row.contains("C．"))) {
                            questionHashMap.get((count[0] - 1)).getAnswerList().add("C");
                        } else if ((row.contains("D") && !row.contains("D．"))) {
                            questionHashMap.get((count[0] - 1)).getAnswerList().add("D");
                        } else if ((row.contains("E") && !row.contains("E．"))) {
                            questionHashMap.get((count[0] - 1)).getAnswerList().add("E");
                        }
                    }
                }

        );

        questionHashMap.forEach((k, v) -> {
            v.setQuestion(v.getQuestion().replaceAll("A",""));;
            v.setQuestion(v.getQuestion().replaceAll("B",""));;
            v.setQuestion(v.getQuestion().replaceAll("C",""));;
            v.setQuestion(v.getQuestion().replaceAll("D",""));;
            v.setQuestion(v.getQuestion().replaceAll("E",""));;
        });
        questionHashMap.forEach((k, v) -> {
            System.out.println(v);
        });


    }


}
