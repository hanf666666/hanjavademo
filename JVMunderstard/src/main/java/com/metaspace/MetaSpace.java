package com.metaspace;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * to do
 *
 * @author Hj
 * @date 2022/1/24
 */
public class MetaSpace extends ClassLoader {

    public static List<Class<?>> createClasses() {
        // �����
        List<Class<?>> classes = new ArrayList<Class<?>>();
        // ѭ��1000������1000����ͬ���ࡣ
        for (int i = 0; i < 1000; ++i) {
            ClassWriter cw = new ClassWriter(0);
            // ����һ��������ΪClass{i}�����ķ�����Ϊpublic������Ϊjava.lang.Object����ʵ���κνӿ�
            cw.visit(Opcodes.V1_1, Opcodes.ACC_PUBLIC, "Class" + i, null,
                    "java/lang/Object", null);
            // ���幹�캯��<init>����
            MethodVisitor mw = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>",
                    "()V", null, null);
            // ��һ��ָ��Ϊ����this
            mw.visitVarInsn(Opcodes.ALOAD, 0);
            // �ڶ���ָ��Ϊ���ø���Object�Ĺ��캯��
            mw.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object",
                    "<init>", "()V");
            // ������ָ��Ϊreturn
            mw.visitInsn(Opcodes.RETURN);
            mw.visitMaxs(1, 1);
            mw.visitEnd();
            MetaSpace test = new MetaSpace();
            byte[] code = cw.toByteArray();
            // ������
            Class<?> exampleClass = test.defineClass("Class" + i, code, 0, code.length);
            classes.add(exampleClass);
        }
        return classes;
    }
}


