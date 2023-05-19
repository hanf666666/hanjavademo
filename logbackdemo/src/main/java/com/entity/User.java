package com.entity;

import lombok.Data;

import java.util.Objects;

/**
 * to do
 *
 * @author Hj
 * @date 2023/5/8
 */
@Data
public class User {
    private String userName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "userName111111111='" + userName + '\'' +
//                '}';
//    }
}
