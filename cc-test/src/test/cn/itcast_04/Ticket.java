package cn.itcast_04;

public class Ticket implements Runnable {

	private int ticket = 100;

	@Override
	public void run() {
		while (true) {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "���ڳ��۵�"
						+ (ticket--) + "��Ʊ");
			}
		}
	}

}
