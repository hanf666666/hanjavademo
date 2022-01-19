package com.mt.entity.Optional.demo01;

import java.util.Optional;

/**
 * to do
 *  Optional �ӿڻ�����ϸ�о�
 * @author Hj
 * @date 2021/12/2
 */
public class maintest1 {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");

        System.out.println(optional.isPresent());           // true
        System.out.println(optional.get());                 // "bam"
        System.out.println(optional.orElse("fallback"));    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}
