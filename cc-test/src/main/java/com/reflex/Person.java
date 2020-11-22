package com.reflex;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shanglei
 * @date 2018/1/19.
 */
public class Person implements Serializable {

    private String name;
    private int age;

    public Person(String par1, int par2) {
        name=par1;
        age=par2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // get/set方法

    public static void main(String[] args)
        throws InvocationTargetException, IllegalAccessException, IntrospectionException {
        Person person = new Person("luoxn28", 23);
        Person person1 = new Person("luoxn", 23);
        Class clazz = person.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //此处key是字段名称 name或者key
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(person);
            Object value1 = method.invoke(person1);

            System.out.println(key + ":" + value);
            System.out.println(key + ":" + value1);

        }
    }


}