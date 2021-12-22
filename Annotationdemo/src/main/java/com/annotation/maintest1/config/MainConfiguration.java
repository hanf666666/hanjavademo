package com.annotation.maintest1.config;


import com.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * to do
 * Configuration等于beans.xml配置文件
 *
 * @author Hj
 * @date 2021/9/12
 */

@Configuration
@ComponentScan(value = "com"
        , excludeFilters = {
        @Filter( value = {Controller.class},
                type = FilterType.ANNOTATION

        )}
////        , useDefaultFilters = false
)
public class MainConfiguration {
    @Bean
    public Student student2() {

        return new Student("hanjing");
    }


}
