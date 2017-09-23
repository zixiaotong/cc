package cn.itcast_06;

/*
 *	解决问题：
 *		通过同步代码块解决问题的。
 *
 *	解决问题的分析过程。
 *		举例：
 *			火车上厕所。
 */
public class TicketDemo {
	public static void main(String[] args) {
		// 创建一个票资源对象
		Ticket t = new Ticket();

		// 创建四个线程对象
		Thread t1 = new Thread(t, "窗口1");
		Thread t2 = new Thread(t, "窗口2");
		Thread t3 = new Thread(t, "窗口3");
		Thread t4 = new Thread(t, "窗口4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
