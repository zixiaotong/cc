package com.mode.simple_mode;

/*
 * ����ģʽ������ʽ����
 *
 * 		����ʽ���õ�ʱ��������
 * 		����ʽ������������󡣿����г��á�
 */
public class Student {
	// ����˽��
	// ������紴������
	private Student() {
	}

	// ������һ������
	// ��private����Ϊ�˲������ֱ�ӷ���
	// ��static������Ϊ��ֻ̬�ܷ��ʾ�̬
	private static Student s = new Student();

	// �����ķ��ʷ�ʽ
	// Ϊ����������ֱ��ʹ�ã��þ�̬����
	public static Student getStudent() {
		return s;
	}

	// ...

	public void show() {
		System.out.println("show");
	}
}
