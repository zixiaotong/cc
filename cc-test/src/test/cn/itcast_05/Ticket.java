package cn.itcast_05;

/*
 * public static void sleep(long millis):˯��ָ���ĺ���ֵ��
 */
public class Ticket implements Runnable {

	private int ticket = 100;

	// @Override
	// public void run() {
	// while (true) {
	// // t1,t2,t3,t4
	// // ticket=100������t1�����ˡ���t1˯�ߵ�ʱ��t2������CPU��ִ��Ȩ��
	// if (ticket > 0) {
	// // t1�����ˣ�t2�����ˡ�
	// try {
	// // �ߵ����t1˯����
	// // �ߵ����t2˯����
	// // t1�ѹ����ˣ�����û����ִ��Ȩ��ǡ��t2�ѹ����ˣ�����������ˡ�
	// // �ȴ�����
	// Thread.sleep(10);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// System.out.println(Thread.currentThread().getName() + "���ڳ��۵�"
	// + (ticket--) + "��Ʊ");
	// // ����2���ڳ��۵�100��Ʊ
	//
	// // ticket--:��������һ�������������������һ���Լ��������������һ����ֵ������
	// // ��t2�������ϣ���t1������ִ��Ȩ����ô��t1���������
	// // ����1���ڳ��۵�100��Ʊ
	// // ticket=99
	// }
	// }
	// }

	@Override
	public void run() {
		while (true) {
			// t1,t2,t3,t4
			// ticket=1��ʱ��
			// ����t1�����ˣ�
			// t2�����ˣ�
			// t3�����ˣ�
			// t4�����ˣ�
			if (ticket > 0) {
				try {
					// t1�����ˣ�t1˯����
					// t2�����ˣ�t2˯����
					// t3�����ˣ�t3˯����
					// t4�����ˣ�t4˯����
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// t1�ѹ�����������CPU��ִ��Ȩ��
				// t2...
				// t3...
				// t4...
				System.out.println(Thread.currentThread().getName() + "���ڳ��۵�"
						+ (ticket--) + "��Ʊ");

				// ����1���ڳ��۵�1��Ʊ ticket=0
				// ����2���ڳ��۵�0��Ʊ ticket=-1
				// ����3���ڳ��۵�-1��Ʊ ticket=-2
				// ����4���ڳ��۵�-2��Ʊ ticket=-3
			}
		}
	}

}
