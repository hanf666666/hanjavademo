package com.Thread.test04_DBUtils��ʹ��;

import com.it.domain.Users;
import com.it.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//1. ��ȡ����ִ��SQL���Ķ���.
//2. ִ��SQL���, ��ȡ�����.
//3. ���������
public class Test02_������ѯ��� {
    /*
        ArrayHandler:  �ѵ�һ�����ݷ�װ��Object[]
     */
    @Test
    public void method1() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "select * from users where uid = ? ;";
        try {
            Object[] arr = qr.query(sql, new ArrayHandler(), 6);
            //3. ���������
            System.out.println(Arrays.toString(arr));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        ArrayListHandler:  ��ÿһ�����ݷ�װ��Object[], �������: List<Object[]>
     */
    @Test
    public void method2() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "select * from users ;";
        try {
            List<Object[]> list = qr.query(sql, new ArrayListHandler());
            //3. ���������
            //iter: ��ǿfor�Ŀ�ݼ�
            for (Object[] obj : list) {
                System.out.println(Arrays.toString(obj));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     MapHandler:  �ѵ�һ�����ݷ�װ��Map<String,Object>,  ��������, ���е�ֵ��ֵ
   */
    @Test
    public void method3() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "select * from users where uid = ? ;";
        try {
            Map<String, Object> map = qr.query(sql, new MapHandler(), 2);
            //3. ���������
            System.out.println(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
       MapListHandler:  ��ÿһ�����ݷ�װ��Map, �������: List<Map<String,Object>>
    */
    @Test
    public void method4() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "select * from users ;";
        try {
            List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
            //3. ���������
            for (Map<String, Object> map : list) {
                //���ű���
                for (String key : map.keySet()) {
                    System.out.print(key + "..." + map.get(key) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
       BeanHandler:  �ѵ�һ�����ݷ�װ��JavaBean����.
     */
    @Test
    public void method5() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "select * from users where uid = ? ;";
        try {
            // ����.class:  ���Ի�ȡ������ֽ����ļ�����.
            //qr.query(sql, new BeanHandler<Users>(Users.class));
            Users user = qr.query(sql, new BeanHandler<>(Users.class), 4);
            //3. ���������
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
       BeanListHandler:  ��ÿһ�����ݷ�װ��JavaBean����, �������: List<JavaBean��>
     */
    @Test
    public void method6() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "select * from users ;";
        try {
            List<Users> list = qr.query(sql, new BeanListHandler<>(Users.class));
            //3. ���������
            for (Users users : list) {
                System.out.println(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     ScalarHandler:  ��������ֵ��ѯ.
   */
    @Test
    public void method7() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "select count(*) from users;";
        try {
            Object obj = qr.query(sql, new ScalarHandler());
            //3. ���������
            System.out.println(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     ColumnListHandler:  ������ѯĳһ�е�����
   */
    @Test
    public void method8() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "select * from users;";
        try {
            //��������  ��ȡ���е�ֵ.
//            List<Object> list = qr.query(new ColumnListHandler("password"), sql);
            List<Object> list = null;
            System.out.println(list);
            //3. ���������
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     KeyedHandler:  ��ÿһ�����ݷ�װ��Map, �������: Map<ָ������,<Map<String,Object>>
   */
    @Test
    public void method9() {
        //1. ��ȡ����ִ��SQL���Ķ���.
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //2. ִ��SQL���, ��ȡ�����.
        String sql = "select * from users;";
        try {
            //��ָ��������ʾ�ڸ��еĿ�ͷ, ��߸����Ǹ��е���Ϣ.
//            Map<Object, Map<String, Object>> maps = qr.query(sql, new KeyedHandler("username"));
            Map<Object, Map<String, Object>> maps=null;
            //3. ���������
            for (Object key : maps.keySet()) {
                Map<String, Object> value = maps.get(key);
                System.out.println(key + "..." + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
