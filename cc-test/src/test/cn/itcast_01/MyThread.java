package cn.itcast_01;

public class MyThread extends Thread {
	// public void show() {
	//
	// }
	//
	// public void method() {
	//
	// }

	@Override
	public void run() {
		for (int x = 0; x < 100; x++) {
			System.out.println(getName() + "---hello" + x);
		}
	}

}
