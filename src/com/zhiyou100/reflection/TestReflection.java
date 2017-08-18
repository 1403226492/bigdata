package com.zhiyou100.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.zhiyou100.generics.Singleton;

public class TestReflection {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// Class<Student> clazz = getClass1();
		// Constructor[] constructors = clazz.getConstructors();
		// for(Constructor c : constructors){
		// System.out.println(c);
		// }

		// Constructor[] constructors = clazz.getDeclaredConstructors();
		// for(Constructor c : constructors){
		// System.out.println(c);
		// }

		Singleton instance = Singleton.getInstace();
		System.out.println(instance);
		System.out.println(Singleton.getInstace());
		System.out.println(Singleton.getInstace());
		System.out.println(Singleton.getInstace());
		
		Class<Singleton> clazz = Singleton.class;
		Constructor<Singleton> cons = clazz.getDeclaredConstructor(null);
		System.out.println(cons);
		cons.setAccessible(true);
		Singleton singleton = cons.newInstance(null);
		System.out.println(singleton);
	}

	@SuppressWarnings("unused")
	private static void test1() {
		Class<Student> studentClass1 = getClass1();
		Class<Student> studentClass2 = getClass2();
		Class<Student> studentClass3 = getClass3();

		System.out.println(studentClass1 == studentClass2);
		System.out.println(studentClass2 == studentClass3);
	}

	public static void test2() throws Throwable {
		Class<Student> clazz = getClass1();
		Constructor<Student> noArgCon = clazz.getConstructor(null);
		Student student = noArgCon.newInstance(null);
		// System.out.println(student);

		Constructor<Student> hasArgCon = clazz.getConstructor(long.class, String.class, int.class, String.class);
		Student student2 = hasArgCon.newInstance(1L, "张三", 25, "郑州市经开区通信产业园");
		// System.out.println(student2);
	}

	private static Class<Student> getClass1() {
		Class<Student> ret = Student.class;
		return ret;
	}

	@SuppressWarnings("unchecked")
	private static Class<Student> getClass2() {
		Class<Student> ret = null;
		try {
			ret = (Class<Student>) Class.forName("com.zhiyou100.reflection.Student");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	private static Class<Student> getClass3() {
		// Student stu = new Student();
		// @SuppressWarnings("unchecked")
		// Class<Student> ret = (Class<Student>) stu.getClass();
		return null;
	}
}
