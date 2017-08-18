package com.zhiyou100.generics;

public class GenericUtil {
	
	/**
	 * ����һ�����������м�λ�õ�Ԫ��
	 * �÷����Ƿ��ͷ�����������Ϣ�ŵ�Ȩ�����η�֮��
	 * �����Ÿ÷����������ø÷��ͱ����Ϣ��Ϊ����������ֵ�ͷ����еı������͡�
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
	 * ��̬���ͷ�����Ҫ��������Ϣ�ŵ�static֮��
	 * ������Ϣ���������÷����ķ���ֵ���ͣ��������ͣ����ڲ��ֲ��������͡�
	 * @param arrays
	 * @return
	 */
	public static<T> T getLast(T[] arrays){
		return arrays[arrays.length-1];
	}
}
