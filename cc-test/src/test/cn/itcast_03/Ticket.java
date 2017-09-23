package cn.itcast_03;

public class Ticket extends Thread {
	// 为了保证多个对象共享数据
	private static int ticket = 100;

	public Ticket(String name) {
		super(name);
	}

	@Override
	public void run() {
		// 定义100张票
		// int ticket = 100; //定义在这里，表示每个窗口100张票，不符合题目要求。
		while (true) {
			if (ticket > 0) {
				System.out.println(getName() + "正在出售第" + (ticket--) + "张票");
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

