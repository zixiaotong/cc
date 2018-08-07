package com.mode.simplemode;

/**
 * @author shanglei
 */
public class Student {
    private Student() {
    }

    private static Student s = new Student();

    public static Student getStudent() {
        return s;
    }

    public void show() {
        System.out.println("show");
    }

    public static void main(String[] args) {
        Student s1 = Student.getStudent();
        Student s2 = Student.getStudent();
        System.out.println(s1 == s2);
        s1.show();
        s2.show();
    }
}
