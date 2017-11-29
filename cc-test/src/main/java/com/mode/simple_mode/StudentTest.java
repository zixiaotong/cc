package com.mode.simple_mode;

/**
 * @author shanglei
 */
public class StudentTest {
	public static void main(String[] args) {
		// Student s1 = new Student();

		// Student.s = null;

		// ��ʾ
		Student s1 = Student.getStudent();
		Student s2 = Student.getStudent();
		System.out.println(s1 == s2);

		s1.show();
		s2.show();
		
		// Runtime r = Runtime.getRuntime();
		// try {
		// r.exec("notepad");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
}
