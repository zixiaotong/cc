package cn.itcast_03;

/*
 * ��������100��Ʊ��Ҫ��4�����ڳ��ۡ�
 * ͨ��һ���򵥵ķ���������֪��������4���߳�����Ʊ�����ԣ�����ͨ�����̳߳�����ģ����Ʊ������
 * �����̳߳����ʵ�ַ�����2�֣�
 * ����1���̳�Thread��
 * ����2��ʵ��Runnable�ӿ�
 * 
 * �������÷�ʽ1������
 */
public class TicketDemo {
	public static void main(String[] args) {
		Ticket t1 = new Ticket("����1");
		Ticket t2 = new Ticket("����2");
		Ticket t3 = new Ticket("����3");
		Ticket t4 = new Ticket("����4");

		// setName(String name)

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
