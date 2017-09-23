package cn.itcast_05;
/*
 * 我们的程序到现在为止出现了一个小问题：
 * 		有相同的票出现多次:程序的执行必须是最基本的单元执行。也就是说在一个时间片上，执行的是一个最基本的东西。
 * 					      是一个不能拆分的东西。而我们的输出语句本身就是这样的一个基本动作。
 * 					      但是在输出语句中的：ticket--
 * 						这里隐含了几个动作：
 * 								A:输出以前的值。
 * 								B:自减。
 * 								C:自减后的值赋给本身。
 * 		还有负数票的出现：
 * 						多个线程的执行有延迟性和随机性。
 * 我们要先分析是如何出现的,这个出现的原因也就是线程安全问题：
 * 		A:有共享数据。
 * 		B:有多条语句操作共享数据。
 * 		C:多线程环境。
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
