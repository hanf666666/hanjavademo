package com.annotation.maintest2;


import com.annotation.annotation.self.Column;
import com.annotation.annotation.self.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/***
 * �Զ���ע�������
 * @author liaot
 *
 */
public class Test {
    public static void main(String[] args) {
        FilterEntity f1 = new FilterEntity();
        f1.setId(1); //��ѯidΪ1���û�

        FilterEntity f2 = new FilterEntity();
        f1.setUsername("lili"); //��ѯ�û���Ϊlili���û�

        FilterEntity f3 = new FilterEntity();
        f3.setCity("����,��ɳ,����"); //��ѯ�ص�������������֮���

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

    }

    private static String query(Object f) {
        StringBuilder sql = new StringBuilder();
        //��ȡ��class
        Class c1 = f.getClass();
        //��ȡtable������
        boolean exists = c1.isAnnotationPresent(Table.class);
        if(!exists) {
            return null;
        }
        Table t = (Table)c1.getAnnotation(Table.class);
        //�������
        String tableName = t.value();
        sql.append("select * from ").append(tableName).append(" where 1=1 ");
        //�������е��ֶ�
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            //�ж��Ƿ�������ע��
            boolean Fexists = field.isAnnotationPresent(Column.class);
            if(!Fexists) {
                continue;
            }
            //��ȡע��
            Column column = field.getAnnotation(Column.class);
            String ColumuName = column.value();


            //��ȡ�ֶε�ֵ
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
            Method method = null;
            Object ColumuValue = null;
            try {
                method = c1.getMethod(getMethodName);
                ColumuValue = method.invoke(f);

            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
            //int�Ͳ���Ҫ�ӵ����ţ�String����Ҫ�ӵ�����
            if(ColumuValue instanceof Integer && (int)ColumuValue != 0){
                sql.append("and " + ColumuName + " = " + ColumuValue + " ");
            }else if(ColumuValue instanceof String){
                if( ((String) ColumuValue).contains(",") ){
                    String[] values = ((String) ColumuValue).split(",");
                    sql.append("and " + ColumuName + " in (");
                    for(int i=0; i<values.length; i++) {
                        sql.append("'").append(values[i]).append(" ',");
                    }
                    sql.deleteCharAt(sql.length() -1);
                    sql.append(")");
                }else{
                    sql.append("and " + ColumuName + " = '" + ColumuValue + "' ");
                }
            }
        }
        return sql.toString();
    }
}
