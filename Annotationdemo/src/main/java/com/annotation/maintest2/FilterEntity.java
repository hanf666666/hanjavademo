package com.annotation.maintest2;


import com.annotation.annotation.self.Column;
import com.annotation.annotation.self.Table;

/***
 * java注解样例   利用注解将此表映射到数据库的表
 * @author Hj
 * @date 2021/12/22
 *
 */
@Table("t_user")
public class FilterEntity {
    //定义字段属性
    @Column("id")
    private int id;
    @Column("username")
    private String username;
    @Column("nickName")
    private String nickName;
    @Column("age")
    private String age;
    @Column("city")
    private String city;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

}

