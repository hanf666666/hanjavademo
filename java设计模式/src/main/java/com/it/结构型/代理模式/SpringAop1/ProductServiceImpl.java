package com.it.�ṹ��.����ģʽ.SpringAop1;

public class ProductServiceImpl implements ProductService {

    @Override
    public void add() {
        System.out.println("�����Ʒ...");
    }

    @Override
    public void edit() {
        System.out.println("�޸���Ʒ...");
    }

    @Override
    public void delete() {
        System.out.println("ɾ����Ʒ...");
    }

    @Override
    public void query() {
        System.out.println("��ѯ��Ʒ...");
    }
}
