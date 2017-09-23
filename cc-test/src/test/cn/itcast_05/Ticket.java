package cn.itcast_05;

/*
 * public static void sleep(long millis):睡眠指定的毫秒值。
 */
public class Ticket implements Runnable {

	private int ticket = 100;

	// @Override
	// public void run() {
	// while (true) {
	// // t1,t2,t3,t4
	// // ticket=100，假设t1抢到了。当t1睡眠的时候，t2抢到了CPU的执行权。
	// if (ticket > 0) {
	// // t1进来了，t2进来了。
	// try {
	// // 走到这里，t1睡眠了
	// // 走到这里，t2睡眠了
	// // t1醒过来了，但是没抢到执行权，恰好t2醒过来了，立马就抢到了。
	// // 等待动作
	// Thread.sleep(10);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// System.out.println(Thread.currentThread().getName() + "正在出售第"
	// + (ticket--) + "张票");
	// // 窗口2正在出售第100张票
	//
	// // ticket--:首先做了一个输出动作，接着做了一个自减动作，最后还做了一个赋值动作。
	// // 当t2刚输出完毕，被t1抢到了执行权。那么，t1继续输出：
	// // 窗口1正在出售第100张票
	// // ticket=99
	// }
	// }
	// }

	@Override
	public void run() {
		while (true) {
			// t1,t2,t3,t4
			// ticket=1的时候。
			// 假设t1过来了，
			// t2过来了，
			// t3过来了，
			// t4过来了，
			if (ticket > 0) {
				try {
					// t1进来了，t1睡眠了
					// t2进来了，t2睡眠了
					// t3进来了，t3睡眠了
					// t4进来了，t4睡眠了
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// t1醒过来，抢到了CPU的执行权。
				// t2...
				// t3...
				// t4...
				System.out.println(Thread.currentThread().getName() + "正在出售第"
						+ (ticket--) + "张票");

				// 窗口1正在出售第1张票 ticket=0
				// 窗口2正在出售第0张票 ticket=-1
				// 窗口3正在出售第-1张票 ticket=-2
				// 窗口4正在出售第-2张票 ticket=-3
			}
		}
	}

}
