package com.basecal;

/**
 * 正数三码同，负数符号定，数值取反加一，原补互转通。
 * 异或：同0异1，自消0，零不变。
 * @author Hj
 * @date 2026/9/19
 */
public class ComplementXorTest {

    /**
     * 将整数转换为指定比特数的补码二进制字符串。
     * 例如：toBinaryString(-5, 8) -> "11111011"
     */
    public static String toBinaryString(int value, int bits) {
        // 计算掩码，例如 bits=8 时 mask=255 (0xFF)
        int mask = (1 << bits) - 1;
        // 取低 bits 位。对于负数，& mask 会得到其补码的低位表示（正数）
        int lowBits = value & mask;
        // 转为二进制字符串（无符号）
        String binary = Integer.toBinaryString(lowBits);
        // 左侧补零至指定长度
        while (binary.length() < bits) {
            binary = "0" + binary;
        }
        return binary;
    }

    /**
     * 将二进制字符串逐位取反。
     */
    private static String invertBits(String bits) {
        StringBuilder sb = new StringBuilder();
        for (char c : bits.toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    /**
     * 测试正数的原码、反码、补码相同。
     */
    public static void testPositiveCodes() {
        int value = 5;
        int bits = 8;
        String binary = toBinaryString(value, bits);
        System.out.println("正数 " + value + " 的8位补码: " + binary);
        // 正数的原码=反码=补码，所以二进制表示相同
        if (!binary.equals("00000101")) {
            throw new AssertionError("正数补码错误，期望 00000101，实际 " + binary);
        }
        System.out.println("验证通过：正数原码=反码=补码 = " + binary);
    }

    /**
     * 测试负数 -5 的原码、反码、补码，并验证它们之间的关系。
     */
    public static void testNegativeCodes() {
        int value = -5;
        int bits = 8;

        // 1. 补码：Java 中整数的实际存储形式
        String complement = toBinaryString(value, bits);
        System.out.println("负数 " + value + " 的8位补码: " + complement);
        if (!complement.equals("11111011")) {
            throw new AssertionError("-5的补码应为 11111011，实际 " + complement);
        }

        // 2. 原码：符号位为1，数值位为绝对值的二进制
        //    绝对值 5 的7位二进制是 0000101，所以原码 = 1 0000101
        String original = "1" + toBinaryString(5, 7);
        System.out.println("负数 " + value + " 的8位原码: " + original);
        if (!original.equals("10000101")) {
            throw new AssertionError("-5的原码应为 10000101，实际 " + original);
        }

        // 3. 反码：符号位不变，数值位逐位取反
        String onesComplement = original.substring(0, 1) + invertBits(original.substring(1));
        System.out.println("负数 " + value + " 的8位反码: " + onesComplement);
        if (!onesComplement.equals("11111010")) {
            throw new AssertionError("-5的反码应为 11111010，实际 " + onesComplement);
        }

        // 4. 验证：补码 = 反码 + 1
        int onesInt = Integer.parseInt(onesComplement, 2); // 将反码视为无符号整数
        String compFromOnes = toBinaryString(onesInt + 1, bits);
        System.out.println("反码 + 1 = " + compFromOnes);
        if (!compFromOnes.equals(complement)) {
            throw new AssertionError("补码应等于反码+1，期望 " + complement + "，实际 " + compFromOnes);
        }

        System.out.println("验证通过：-5 的原码、反码、补码关系正确");
    }

    /**
     * 测试从补码转换回原码，并还原为十进制。
     */
    public static void testComplementToOriginal() {
        int bits = 8;
        String complement = "11111011"; // -5 的补码

        // 补码转原码规则：符号位不变，数值位取反加一
        String sign = complement.substring(0, 1);          // 符号位 '1'
        String valueBits = complement.substring(1);        // 数值位 "1111011"
        String inverted = invertBits(valueBits);           // 取反 -> "0000100"
        int invertedInt = Integer.parseInt(inverted, 2);   // 二进制转十进制 -> 4
        String originalValue = toBinaryString(invertedInt + 1, 7); // 加一 -> 5 -> "0000101"
        String original = sign + originalValue;            // 原码 "10000101"

        System.out.println("补码 " + complement + " 转原码: " + original);
        if (!original.equals("10000101")) {
            throw new AssertionError("补码转原码错误，期望 10000101，实际 " + original);
        }

        // 原码转十进制：符号位为1，数值位为5，所以是 -5
        int decimal = -Integer.parseInt(originalValue, 2);
        System.out.println("对应十进制: " + decimal);
        if (decimal != -5) {
            throw new AssertionError("转回十进制应为 -5，实际 " + decimal);
        }

        System.out.println("验证通过：补码 " + complement + " 可以正确转回原码和十进制 -5");
    }

    /**
     * 测试异或运算：-5 ^ 3
     */
    public static void testXor() {
        int a = -5;
        int b = 3;
        int result = a ^ b;

        System.out.println(a + " ^ " + b + " = " + result);
        System.out.println("  " + toBinaryString(a, 8) + "  (" + a + " 的补码)");
        System.out.println("^ " + toBinaryString(b, 8) + "  (" + b + " 的补码)");
        System.out.println("= " + toBinaryString(result, 8) + "  (" + result + " 的补码)");

        if (result != -8) {
            throw new AssertionError("-5 ^ 3 应为 -8，实际 " + result);
        }
        System.out.println("验证通过：-5 ^ 3 = -8");
    }

    /**
     * 测试异或交换两个变量（不用临时变量）。
     */
    public static void testXorSwap() {
        int x = 5;
        int y = 3;
        System.out.println("交换前: x=" + x + ", y=" + y);

        x = x ^ y; // x = 5 ^ 3 = 6
        y = x ^ y; // y = 6 ^ 3 = 5
        x = x ^ y; // x = 6 ^ 5 = 3

        System.out.println("交换后: x=" + x + ", y=" + y);
        if (x != 3 || y != 5) {
            throw new AssertionError("异或交换失败，期望 x=3, y=5，实际 x=" + x + ", y=" + y);
        }
        System.out.println("验证通过：异或交换成功");
    }

    /**
     * 测试异或的基本性质。
     */
    public static void testXorProperties() {
        int a = 123;
        // a ^ a = 0
        if ((a ^ a) != 0) {
            throw new AssertionError("a ^ a 应为 0");
        }
        // a ^ 0 = a
        if ((a ^ 0) != a) {
            throw new AssertionError("a ^ 0 应为 a");
        }
        // 两次异或同一个值会还原
        int mask = 0x55;
        if (((a ^ mask) ^ mask) != a) {
            throw new AssertionError("两次异或同一值应还原");
        }
        System.out.println("验证通过：异或性质 a^a=0, a^0=a, 两次异或还原");
    }

    public static void main(String[] args) {
        System.out.println("========== 原码、反码、补码与异或测试 ==========");
        testPositiveCodes();
        System.out.println("----------------------------------------");
        testNegativeCodes();
        System.out.println("----------------------------------------");
        testComplementToOriginal();
        System.out.println("----------------------------------------");
        testXor();
        System.out.println("----------------------------------------");
        testXorSwap();
        System.out.println("----------------------------------------");
        testXorProperties();
        System.out.println("========== 所有测试通过！ ==========");
    }
}

