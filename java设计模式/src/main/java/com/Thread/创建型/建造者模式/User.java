package com.Thread.������.������ģʽ;

class User {
    // �����ǡ�һ�ѡ�������
    private String name;
    private String password;
    private String nickName;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }

    // ���췽��˽�л�����Ȼ�ͻ��˾ͻ�ֱ�ӵ��ù��췽����
    private User(String name, String password, String nickName, int age) {
        this.name = name;
        this.password = password;
        this.nickName = nickName;
        this.age = age;
    }
    // ��̬��������������һ�� Builder�������һ��Ҫ�У�����д���������һ���ܺõ�ϰ�ߣ�
    // ��Щ����Ҫ�����д new User.UserBuilder().a()...build() ����ȥ��û��ô��
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        // �����Ǻ� User һģһ����һ������
        private String  name;
        private String password;
        private String nickName;
        private int age;

        private UserBuilder() {
        }

        // ��ʽ�������ø�������ֵ������ this���� UserBuilder
        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        // build() �������� UserBuilder �����úõ����ԡ����ơ��� User �С�
        // ��Ȼ�������� �����ơ� ֮ǰ�������
        public User build() {
            if (name == null || password == null) {
                throw new RuntimeException("�û������������");
            }
            if (age <= 0 || age >= 150) {
                throw new RuntimeException("���䲻�Ϸ�");
            }
            // �����������衱Ĭ��ֵ���Ĺ���
            if (nickName == null) {
                nickName = name;
            }
            return new User(name, password, nickName, age);
        }
    }
}
