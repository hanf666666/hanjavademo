package com.base01.test08_�����ڲ��ི��.innerclass;



/**
 * to do
 *
 * @author Hj
 * @date 2024/8/8
 */
public class Demo01 {
    public static void main(String[] args) {
//       OutClassInstance.InnerClass innerClass = new OutClassInstance().new InnerClass(); //ע�����ⲿ��ʵ��.new���ڲ���

        OutClassInstance outClassInstance1 = new OutClassInstance();
        outClassInstance1.setOutName("setOutName111");
        //�Ǿ�̬�ڲ�������������ⲿ����������
        OutClassInstance.InnerClass innerClass = outClassInstance1.new InnerClass();
        innerClass.setInnerName("setInnerName111");
        System.out.println(innerClass);


        OutClassInstance outClassInstance = new OutClassInstance(); //ע�����ⲿ��ʵ��.new���ڲ���
        outClassInstance.setOutName("setOutName1111");
        System.out.println(outClassInstance);

        //����̬�ڲ��࣬�ڲ����Ǿ�̬�ģ���ô�������༶������Ա�ˣ����������ڶ�������ڡ����Ծ�̬�ڲ���
        OutClassInstance.StaticInner staticInner = new OutClassInstance.StaticInner();
        staticInner.setInnerStaticName("setInnerStaticName1111");
        System.out.println(staticInner);



    }
}
