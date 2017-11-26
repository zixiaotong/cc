package com.thread.timertask;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTask1 {
	public static void main(String[] args) {
		TimerTask task = new TimerTask (){
			public void run() {
				boolean flag= true;
				int count = 100;
				Object obj = new Object();
				while (flag) {
					synchronized (obj) {
						if (count > 0) {
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println(Thread.currentThread().getName() + "..."+ (count--));
						} else {
							flag = false;
						}
					}
				}
			}
		};
		Timer tt = new Timer(false);
		//Timer tt2 = new Timer(false);
		//从现在起�?1s后，每隔1s执行
		tt.schedule(task,1000,2000);
		//tt2.schedule(task,1000,2000);
	}
	
}
