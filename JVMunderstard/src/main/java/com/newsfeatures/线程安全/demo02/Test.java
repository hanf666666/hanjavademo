package com.newsfeatures.�̰߳�ȫ.demo02;

/**
 * 200,  b 12
   200, a   11
 ����ԭ����,��a�߳�ִ��add����ʱ,����
 if("a".equals(str)){
 count=100;//���Ҹ�ֵ��100,����ʱ�̱߳�����3s
 ��ʱ�߳�b������,���� count=200;,����ӡ,��仰200,  b 12
 ����a�߳�������,����count=100����ֵλ200  ,���ӡ��200, a   11
 ������,�Ǹö�ʱ��ֻ�иö����һ���̷߳��ʸ÷���
 ����,�Ǹö�ʱ��ֻ�и����һ���̷߳��ʸ÷���
 ����˵,����>������


 */
public class Test {
    public static void main(String[] args) {
        Count count=new Count();
        ThreadA a=new ThreadA(count);
        a.start();

        ThreadB b=new ThreadB(count);
        b.start();
    }
}
