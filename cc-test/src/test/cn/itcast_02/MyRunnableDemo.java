package cn.itcast_02;

/*
 * 面试题：
 * 		run()和start()方法的区别?
 * 		A:run()方法封装了被线程执行的代码，单独使用，仅仅是普通方法的调用。
 * 		B:start()方法调用做了两件事情，首先让线程启动，然后又jvm自动调用run()方法。
 * 
 * 线程对象如果我们没有给名字，那么，它会自动起名字。
 * 		Thread-编号。编号从0开始。
 * 
 * 方式2：实现Runnable接口。
 * 步骤：
 * 		A:自定义类实现Runnable接口。
 * 		B:重写run()方法。
 * 		C:创建自定义类对象。
 * 		D:创建Thread类对象，把自定义类对象作为构造参数传递。并启动线程对象。
 */
public class MyRunnableDemo {
	public static void main(String[] args) {
		// 创建实现了Runnable接口的子类对象。
		MyRunnable my = new MyRunnable();

		// my.run();
		// my.start();

		// Thread(Runnable target)
		// Thread t1 = new Thread(my);
		// Thread t2 = new Thread(my);
		// Thread t3 = new Thread(my);

		// t1.setName("曹操");
		// t2.setName("赵云");
		// t3.setName("小乔");

		// Thread(Runnable target, String name)
		Thread t1 = new Thread(my, "曹操");
		Thread t2 = new Thread(my, "赵云");
		Thread t3 = new Thread(my, "小乔");

		t1.start();
		t2.start();
		t3.start();
	}
}
