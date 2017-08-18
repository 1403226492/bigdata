package com.zhiyou100.generics;

public class GenericUtil {
	
	/**
	 * 返回一个泛型数组中间位置的元素
	 * 该方法是泛型方法，泛型信息放到权限修饰符之后，
	 * 代表着该方法可以是用该泛型标记信息作为参数，返回值和方法中的变量类型。
	 * @param arrays
	 * @return
	 */
	public<T> T getMiddle(T[] arrays){
		T ret = null;
		if(arrays == null){
			ret = null;
		}else{
			ret = arrays[(arrays.length-1)/2];
		}
		return ret;
	}
	
	/**
	 * 静态泛型方法，要将泛型信息放到static之后，
	 * 泛型信息可以用作该方法的返回值类型，参数类型，和内部局部变量类型。
	 * @param arrays
	 * @return
	 */
	public static<T> T getLast(T[] arrays){
		return arrays[arrays.length-1];
	}
}
