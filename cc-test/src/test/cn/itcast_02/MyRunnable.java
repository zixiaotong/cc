package cn.itcast_02;

/*
 * ע�⣺
 * ʵ��Runnable�ӿڵ��౾�ʲ���һ���߳��ࡣ���ԣ���û��getName()������
 * ����������֪�����ĸ��߳���ִ�У�����Thread�������ṩ��һ��������ȡ��ǰ����ִ�е��̶߳���
 * 		public static Thread currentThread()�����ضԵ�ǰ����ִ�е��̶߳�������á� 
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
