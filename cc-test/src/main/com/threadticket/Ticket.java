package com.threadticket;

import java.util.HashMap;
import java.util.Map;

/*
 * ͬ������飺
 * 		synchronized(����){
 * 			��ͬ���Ĵ��롣
 * 		}
 * 
 * 		���⣺
 * 			A:������˭?
 * 				������ǲ�֪�������Ǿ���Object�Ķ���
 * 			B:��ͬ���Ĵ�������Щ?
 * 				���ﵼ�³�������⣬�ͼ������
 * 				��ô������ᵼ�³�������?
 * 					������ҸղŽ�������������߳������ԭ��
 * 
 * 		ע�⣺
 * 			���ͬ��������������Ҫ��ԭ������Ǹ������ϡ�
 * 			��Ϊ����������һ�����������԰Ѵ�����������
 * 			��������ʱ��һ��Ҫע�⣬����߳�ʹ�õ���������ͬһ�ѡ�
 */
public class Ticket implements Runnable {

	private int ticket = 100;
	private Object obj = new Object();
	static Map map = new HashMap<String,String>(10);
	@Override
	public void run() {
		while (true) {
			// t1,t2,t3,t4
			// ticket=1,����t1����
			// �������ߵ����һ��ͬ������֪�����뽫��������
			// ���ǣ�����ֻ��t1���ˣ�������������0��
			// t1�ͽ�ȥ�ˣ�һ��ȥ���ѱ�Ǹ�Ϊ1��
			synchronized (obj) {
				if (ticket > 0) {
					try {
						// t1˯��
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "���ڳ��۵�" + (ticket--) + "��Ʊ");
				}
			}
			// t1������
		}
	}

	public static void main(String[] args) {
		map.put("1","1");
	}


}
