package cn.itcast_02;

/*
 * 注意：
 * 实现Runnable接口的类本质不是一个线程类。所以，他没有getName()方法。
 * 而我们又想知道是哪个线程在执行，所以Thread类里面提供了一个方法获取当前正在执行的线程对象。
 * 		public static Thread currentThread()：返回对当前正在执行的线程对象的引用。 
 */
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int x = 0; x < 100; x++) {
			System.out.println(Thread.currentThread().getName() + "---hello"
					+ x);
		}
	}

}
