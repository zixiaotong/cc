package cn.itcast_02;

/*
 * �����⣺
 * 		run()��start()����������?
 * 		A:run()������װ�˱��߳�ִ�еĴ��룬����ʹ�ã���������ͨ�����ĵ��á�
 * 		B:start()�������������������飬�������߳�������Ȼ����jvm�Զ�����run()������
 * 
 * �̶߳����������û�и����֣���ô�������Զ������֡�
 * 		Thread-��š���Ŵ�0��ʼ��
 * 
 * ��ʽ2��ʵ��Runnable�ӿڡ�
 * ���裺
 * 		A:�Զ�����ʵ��Runnable�ӿڡ�
 * 		B:��дrun()������
 * 		C:�����Զ��������
 * 		D:����Thread����󣬰��Զ����������Ϊ����������ݡ��������̶߳���
 */
public class MyRunnableDemo {
	public static void main(String[] args) {
		// ����ʵ����Runnable�ӿڵ��������
		MyRunnable my = new MyRunnable();

		// my.run();
		// my.start();

		// Thread(Runnable target)
		// Thread t1 = new Thread(my);
		// Thread t2 = new Thread(my);
		// Thread t3 = new Thread(my);

		// t1.setName("�ܲ�");
		// t2.setName("����");
		// t3.setName("С��");

		// Thread(Runnable target, String name)
		Thread t1 = new Thread(my, "�ܲ�");
		Thread t2 = new Thread(my, "����");
		Thread t3 = new Thread(my, "С��");

		t1.start();
		t2.start();
		t3.start();
	}
}
