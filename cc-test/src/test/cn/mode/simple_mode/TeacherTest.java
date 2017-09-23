package cn.mode.simple_mode;

public class TeacherTest {
	public static void main(String[] args) {
		Teacher t1 = Teacher.getTeacher();
		Teacher t2 = Teacher.getTeacher();
		System.out.println(t1 == t2);
		t1.show();
		t2.show();
	}
}
