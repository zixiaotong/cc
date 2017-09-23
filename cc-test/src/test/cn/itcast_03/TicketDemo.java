package cn.itcast_03;

/*
 * 需求：我有100张票，要在4个窗口出售。
 * 通过一个简单的分析后，我们知道这里有4个线程在卖票。所以，我们通过多线程程序来模拟卖票动作。
 * 而多线程程序的实现方案有2种：
 * 方案1：继承Thread类
 * 方案2：实现Runnable接口
 * 
 * 我们先用方式1来做。
 */
public class TicketDemo {
	public static void main(String[] args) {
		Ticket t1 = new Ticket("窗口1");
		Ticket t2 = new Ticket("窗口2");
		Ticket t3 = new Ticket("窗口3");
		Ticket t4 = new Ticket("窗口4");

		// setName(String name)

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
