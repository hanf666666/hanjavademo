package com;

import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

public class CalciteAstDemo {
    public static void main(String[] args) throws SqlParseException {
        String sql = "select id11,name from dw.order where id11>100";

        // 创建解析器
        SqlParser parser = SqlParser.create(sql);
        // 解析SQL得到SqlNode：这就是抽象语法树AST根节点
        SqlNode sqlNode = parser.parseStmt();

        // 打印语法树！！重点，输出树结构
        System.out.println(sqlNode.toString());

    }
}
