package cn.mode.simple_mode;

/*
 * 单例模式（饿汉式）：
 *
 * 		懒汉式：用的时候才造对象。
 * 		饿汉式：进来就造对象。开发中常用。
 */
public class Student {
	// 构造私有
	// 不让外界创建对象
	private Student() {
	}

	// 本身造一个对象
	// 加private，是为了不让外界直接访问
	// 加static，是因为静态只能访问静态
	private static Student s = new Student();

	// 公共的访问方式
	// 为了让外界可以直接使用，用静态修饰
	public static Student getStudent() {
		return s;
	}

	// ...

	public void show() {
		System.out.println("show");
	}
}
