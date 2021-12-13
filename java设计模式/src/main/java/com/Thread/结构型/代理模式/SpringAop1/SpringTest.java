package com.Thread.�ṹ��.����ģʽ.SpringAop1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beansspring.xml")
public class SpringTest {
   /* @Value("#{customerService}")
    private CustomerServiceImpl customerService;*/
    @Value("#{productService}")
    private ProductService productService;
    @Test
    public void demo01() {
        productService.add();
        productService.edit();
        productService.delete();
        productService.query();
     /*   customerService.delete();
        customerService.search();
        customerService.update();
        customerService.save();*/
    }


}
