package cn.itcast_03;

public class Ticket extends Thread {
	// Ϊ�˱�֤�������������
	private static int ticket = 100;

	public Ticket(String name) {
		super(name);
	}

	@Override
	public void run() {
		// ����100��Ʊ
		// int ticket = 100; //�����������ʾÿ������100��Ʊ����������ĿҪ��
		while (true) {
			if (ticket > 0) {
				System.out.println(getName() + "���ڳ��۵�" + (ticket--) + "��Ʊ");
			}
		}
	}
}

/*
 * class Thread { private String name;
 * 
 * public Thread(){}
 * 
 * public Thread(String name){ this.name = name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public String getName() { return name; }
 */

