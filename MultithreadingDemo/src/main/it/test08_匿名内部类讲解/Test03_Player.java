package com.date.test08_�����ڲ��ི��;

public class Test03_Player {
    public static void main(String[] args) {
        //����: ����Player#play();
//        new Player() {
//            @Override
//            public void play() {
//                System.out.println("Ϊ��ѧ�ô�����, �Ͳ�Ҫ�����Ϸ��, �������Ҳ�Ǹ���");
//            }
//        }.play();

        //��̬
        //Player p = Player�ӿڵ��������;
        Player p =  new Player() {
            @Override
            public void play() {
                System.out.println("Ϊ��ѧ�ô�����, �Ͳ�Ҫ�����Ϸ��, �������Ҳ�Ǹ���");
            }
        };
        p.play();
    }
}
