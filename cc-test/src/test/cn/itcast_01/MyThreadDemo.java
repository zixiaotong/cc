package cn.itcast_01;

/*
 * 多线程：一个应用程序有多条执行路径。
 * 		线程：是程序的执行路径，执行单元。
 * 			如果一个程序的只有一条执行路径，那么，该程序就是单线程程序。
 * 			如果一个程序的执行路径有多条，那么，该程序就是多线程程序。
 * 		进程：正在运行的程序。占用了一个内存空间。
 * 
 * 		举例：
 * 			360的管理界面，迅雷下载
 * 			吃饭：
 * 				单进程单线程：一个人一桌菜。
 * 				单进程多线程：多个人一桌菜。
 * 				多进程多线程：多个人多桌菜。
 * 
 * java本身不能直接操作操作系统的资源，所以，多线程程序我们直接通过纯java语言实现不了。
 * 但是，java中的API提供了实现方案。底层是有java语言包装好了，让我们直接使用的。
 * 这个类是：Thread
 * 实现方案有两种：第一种，继承Thread类。
 * 继承Thread类的步骤：
 * 		A:自定义类继承Thread类。
 * 		B:重写run方法。
 * 			为什么呢?因为run方法里面封装的才是被线程执行的代码。
 * 		C:创建自定义类对象并启动。
 * 			如何启动呢?必须调用strat()才是真的启动。
 * 			start()：做了两件事情：启动线程，调用run()方法。
 * 
 * 做个标记，如果能够给线程对象起个名字就好了,你猜可以吗?
 * 可以。
 * 		public final void setName(String name)
 * 		public final String getName()
 */
public class MyThreadDemo {
	public static void main(String[] args) {
		MyThread my1 = new MyThread();
		MyThread my2 = new MyThread();

		// my1.run();
		// my2.run();

		// 设置线程名称
		my1.setName("林青霞");
		my2.setName("刘意");

		my1.start();
		my2.start();
	}
}
