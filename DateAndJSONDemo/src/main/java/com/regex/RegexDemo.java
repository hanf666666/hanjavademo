package com.regex;

/**
 * @author Hj
 * @date 2026/9/19
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java 正则表达式全景 Demo
 * 依次讲解：核心概念 → 前向预查 → 后向预查 → 量词（贪婪/懒惰/占有）→ 实战
 */
public class RegexDemo {

    public static void main(String[] args) {
        System.out.println("========== 1. 核心概念 ==========");
        coreConcept();

        System.out.println("\n========== 2. 前向预查 Lookahead ==========");
        lookahead();

        System.out.println("\n========== 3. 后向预查 Lookbehind ==========");
        lookbehind();

        System.out.println("\n========== 4. 量词：贪婪 / 懒惰 / 占有 ==========");
        quantifiers();

        System.out.println("\n========== 5. 实战：日志解析器 ==========");
        logParser();
    }

    // ==================================================================
    // 1. 核心概念
    // ==================================================================
    private static void coreConcept() {

        // 【1】Pattern 是编译后的正则对象：线程安全，编译一次可反复使用
        //     Matcher 是“一次匹配”的有状态对象：非线程安全，用完即弃
        Pattern p = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");

        // 【2】matches()：要求“整个字符串”完全匹配，等价于 ^...$
        System.out.println("matches  : " + "2024-05-01".matches("\\d{4}-\\d{2}-\\d{2}"));   // true
        System.out.println("matches  : " + "日期2024-05-01".matches("\\d{4}-\\d{2}-\\d{2}")); // false

        // 【3】find()：在任意位置查找，常配合 while 循环取出所有结果（最常用）
        Matcher m = p.matcher("开始 2024-05-01 结束 2025-01-02 结束");
        while (m.find()) {
            System.out.println("find     : 全部=" + m.group(0)
                    + " 年=" + m.group(1)
                    + " 月=" + m.group(2)
                    + " 日=" + m.group(3)
                    + " [start=" + m.start() + ", end=" + m.end() + ")");
        }

        // 【4】lookingAt()：从开头匹配，但不要求匹配到结尾
        Matcher m2 = Pattern.compile("\\d+").matcher("123abc");
        System.out.println("lookingAt: " + m2.lookingAt()); // true

        // 【5】命名捕获组 (?<name>...)：可读性远好于数字下标
        Matcher m3 = Pattern.compile("(?<y>\\d{4})-(?<mo>\\d{2})").matcher("2024-05");
        if (m3.find()) {
            System.out.println("命名组   : y=" + m3.group("y") + ", mo=" + m3.group("mo"));
        }

        // 【6】反向引用 \1（正则内部）与替换引用 $1（替换串中）
        System.out.println("去重复字 : " + "我我喜喜欢欢".replaceAll("(.)\\1", "$1")); // 我喜欢
    }

    // ==================================================================
    // 2. 前向预查 Lookahead —— 看右边，但不吃掉右边
    // ==================================================================
    private static void lookahead() {

        // ---------- (?=X) 肯定前向：右边必须能匹配 X，但 X 不被消耗 ----------
        // 场景：只提取数字，但要求它紧跟 "px"
        Matcher m = Pattern.compile("\\d+(?=px)").matcher("100px 200em 300px");
        while (m.find()) {
            System.out.println("(?=px)  -> " + m.group()); // 100, 300  （px 没被吃掉）
        }

        // 场景：密码至少 8 位，且同时含字母和数字
        // 多个断言在同一位置“叠加”，各自从行首出发试探，谁也不消耗字符
        String pwdRegex = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$";
        System.out.println("密码 abc12345 -> " + "abc12345".matches(pwdRegex)); // true
        System.out.println("密码 abcdefgh -> " + "abcdefgh".matches(pwdRegex)); // false（无数字）

        // ---------- (?!X) 否定前向：右边不能匹配 X ----------
        // 场景：不允许出现“连续 3 个相同字符”
        String noTriple = "^(?!.*(.)\\1{2}).{6,}$";
        System.out.println("aabbcc  -> " + "aabbcc".matches(noTriple));  // true
        System.out.println("aabbbcc -> " + "aabbbcc".matches(noTriple)); // false

        // 场景：数字后面不能是 px —— 注意这里的“坑”
        Matcher m2 = Pattern.compile("\\d+(?!px)").matcher("100px 200em");
        while (m2.find()) {
            System.out.println("(?!px)  -> " + m2.group()); // 10, 200
        }
        // 为什么是 10 而不是 100？因为 \d+ 会回溯：先吃 "100" 发现后面是 px 失败，
        // 退一格吃 "10"，此时后面是 "0px"，不等于 px，断言通过 → 命中 "10"。
        // 想精确排除，需要补上词边界：
        Matcher m3 = Pattern.compile("\\d+\\b(?!px)").matcher("100px 200em");
        while (m3.find()) {
            System.out.println("(?!px)+\\b -> " + m3.group()); // 200
        }

        // ---------- 预查是“零宽断言”：只匹配位置，不消耗字符 ----------
        // 正因为它只匹配位置，才能在同一位置串起多个条件
        String s = "Passw0rd!";
        boolean strong = s.matches(
                "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$");
        System.out.println("强密码 -> " + strong); // true
    }

    // ==================================================================
    // 3. 后向预查 Lookbehind —— 看左边，但不吃掉左边
    // ==================================================================
    private static void lookbehind() {

        String text = "价格 $100，折扣 $20，编号 300";

        // ---------- (?<=X) 肯定后向：左边必须能匹配 X，X 不被消耗 ----------
        Matcher m = Pattern.compile("(?<=\\$)\\d+").matcher(text);
        while (m.find()) {
            System.out.println("(?<=\\$)\\d+ -> " + m.group()); // 100, 20
        }

        // ---------- (?<!X) 否定后向：左边不能匹配 X ----------
        Matcher m2 = Pattern.compile("(?<!\\$)\\b\\d+\\b").matcher(text);
        while (m2.find()) {
            System.out.println("(?<!\\$)\\b\\d+\\b -> " + m2.group()); // 300
        }

        // ---------- 前后向组合：经典“千分位” ----------
        // 思路：站在“左边是数字、右边是 3 的倍数个数字直到结尾”的那个位置，插入逗号
        String num = "1234567890";
        System.out.println("千分位 -> " + num.replaceAll("(?<=\\d)(?=(\\d{3})+$)", ","));
        // 输出：1,234,567,890

        // ---------- 前后向夹击：提取“被包裹”的内容 ----------
        // 取方括号里的内容，但不包含方括号本身
        Matcher m3 = Pattern.compile("(?<=\\[)[^\\]]+(?=\\])")
                .matcher("ERROR [order-service] 超时");
        while (m3.find()) {
            System.out.println("方括号内 -> " + m3.group()); // order-service
        }

        // ---------- Java 后向的限制 ----------
        // Java 要求后向里的长度是“有界的”，可以写：
        //   (?<=\\d{1,3})     ? 有界量词
        //   (?<=abc|abcd)     ? 多分支（各分支长度固定）
        // 不能写：
        //   (?<=\\d+)         ? 无界量词，运行时抛 PatternSyntaxException
        // 替代方案：改用捕获组，或者用 (?<=\\d) 配合其他手段
    }

    // ==================================================================
    // 4. 量词：贪婪 / 懒惰 / 占有
    // ==================================================================
    private static void quantifiers() {

        String html = "<b>加粗</b> 和 <i>斜体</i>";

        // ---------- 贪婪 Greedy（默认）：能吃多少吃多少，然后回溯 ----------
        System.out.println("贪婪 <.+>  -> " + html.replaceAll("<.+>", "[X]"));   // [X]

        // ---------- 懒惰 Reluctant（加 ?）：能吃多少吃多少？不，是能少吃就少吃 ----------
        System.out.println("懒惰 <.+?> -> " + html.replaceAll("<.+?>", "[X]"));  // [X] 和 [X]

        // ---------- 占有 Possessive（加 +）：一口吞到底，绝不回溯 ----------
        System.out.println("\"aaaa\".matches(\"a+a\")   -> " + "aaaa".matches("a+a"));   // true
        System.out.println("\"aaaa\".matches(\"a++a\")  -> " + "aaaa".matches("a++a"));  // false

        // 原子组 ?> 等价于“这一组不再回溯”
        System.out.println("\"aaaa\".matches(\"(?>a+)a\") -> " + "aaaa".matches("(?>a+)a")); // false

        // ---------- 灾难性回溯（Catastrophic Backtracking） ----------
        // 千万别随便跑下面这行：a 每多一个，耗时指数级增长
        // Pattern.compile("(a+)+$").matcher("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!").matches();
        //
        // 成因：嵌套量词 (a+)+ 在失败时会枚举所有切分方式
        // 解法：
        //   1) 简化正则，别嵌套量词 → "a+$"
        //   2) 用占有量词或原子组 → "(?>a+)+$"
        //   3) 限制输入长度 + 设置匹配超时（Matcher 本身无超时，需自己在任务层控制）

        // ---------- 量词速查 ----------
        // 贪婪：X?  X*  X+  X{n}  X{n,}  X{n,m}
        // 懒惰：X?? X*? X+? X{n,m}?
        // 占有：X?+ X*+ X++ X{n,m}+
    }

    // ==================================================================
    // 5. 实战：日志解析器（命名组 + 前后向 + 边界）
    // ==================================================================
    private static void logParser() {
        String line = "2024-05-01 12:30:45 ERROR [order-service] 订单创建失败, id=1001, 金额=$99.50";

        String regex = "^(?<time>\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})"
                + "\\s+(?<level>DEBUG|INFO|WARN|ERROR)"
                + "\\s+\\[(?<service>[^\\]]+)\\]"
                + "\\s+(?<msg>.*)$";

        Matcher m = Pattern.compile(regex).matcher(line);
        if (m.matches()) {
            System.out.println("时间   : " + m.group("time"));
            System.out.println("级别   : " + m.group("level"));
            System.out.println("服务   : " + m.group("service"));
            System.out.println("消息   : " + m.group("msg"));

            String msg = m.group("msg");

            // 用“后向预查”精确抓 id 的值（不把 id= 带出来）
            Matcher idM = Pattern.compile("(?<=id=)\\d+").matcher(msg);
            if (idM.find()) {
                System.out.println("订单ID : " + idM.group());
            }

            // 用“后向预查”抓金额（$ 不进入结果，且带两位小数）
            Matcher amtM = Pattern.compile("(?<=\\$)\\d+\\.\\d{2}").matcher(msg);
            if (amtM.find()) {
                System.out.println("金额   : " + amtM.group());
            }
        }
    }
}
