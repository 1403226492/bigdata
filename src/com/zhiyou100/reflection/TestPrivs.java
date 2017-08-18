package com.zhiyou100.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestPrivs {
	public static void main(String[] args) throws Throwable{
		Class<Student> clazz = Student.class;
//		Constructor<Student> constructor = clazz.getDeclaredConstructor(null);
//		constructor.setAccessible(true);
//		Student stu = constructor.newInstance(null);
//		System.out.println(stu);
//		Package pkg =  clazz.getPackage();
//		System.out.println(pkg.getName());//获取包名，不包含package关键字
		Constructor<Student> constructor = clazz.getConstructor(long.class,String.class,int.class,String.class);
		Student student = constructor.newInstance(1L,"张三",25,"成都市成华区建设路");
		//System.out.println(student);
		
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(student, "马加爵");
		System.out.println(student);
		Method method = clazz.getDeclaredMethod("setAge", int.class);
		method.invoke(student, 35);
		System.out.println(student);
	}
}
