package com.zhiyou100.collections.list;

import java.util.Arrays;

public class HybList<E> implements IList<E> {
	private Object[] element;
	
	/*
	 * size用来记录数组中真实数据的个数，因为我们的数组是
	 * 动态增长的，当增长了之后，数组的后半截是没有内容的，这个时候
	 * 整个数组保存的内容是我们size要记录的个数；
	 * size默认赋值为0，这个没有显示赋值，采用的是每个对象在初始化的
	 * 时候，byte，short，int，long等默认初始值为0；所以这个地方直接声明。
	 * 当我们new的时候，初始值默认已经被赋值为0了。
	 */
	private int size;
	
	private static final int DEFAULT_INIT_SIZE = 10;
	 
	/**
	 * 使用默认的初始化参数（10）来初始化数组
	 */
	public HybList() {
		this(DEFAULT_INIT_SIZE);
	}
	
	/**
	 * 使用指定的初始化参数初始化数组
	 * @param capacity
	 */
	public HybList(int capacity) {
		if(capacity < 0){
			throw new ArrayIndexOutOfBoundsException("数组下标：" + capacity +"超过了数组的下标最小值");
		}
		element = new Object[capacity];
	}
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean add(E e) {
		checkArraySize(size + 1);
		element[size++] = e;
		return true;
	}

	/**
	 * 检测要插入的元素位置是否超过目前底层数组的最大下标，
	 * 如果已经超过，则将数组的长度扩大2倍。
	 * @param i
	 */
	private void checkArraySize(int i) {
		int oldLength = element.length;
		if(i > oldLength){
			/*
			 * 为了防止垃圾收集器在数组赋值的过程中
			 * 把原来数组中的内容给回收掉，这里做一个引用
			 * 占着位置。
			 */
			@SuppressWarnings("unused")
			Object[] oldData = element;
			int newLength = oldLength * 2;
//			 element = new Object[newLength];
//			System.arraycopy(oldData, 0, element, 0, oldData.length);
			element = Arrays.copyOf(element, newLength);
		}
	}

	@Override
	public boolean remove(E e) {
		int index = indexOf(e);
		return remove(index);
	}

	@Override
	public boolean remove(int i) {
		if(i >= size || i < 0){
			throw new ArrayIndexOutOfBoundsException(i+"超过了数组的下标最大值");
		}
		
		//element[i] = null;
		/*
		 * 用来表示i后边需要移动的个数，由于数组的下标是从0开始的
		 * 所以要减去个1
		 */
		int moveCount = size - i -1;
		System.arraycopy(element, i+1, element, i, moveCount);
		size--;
		return true;
	}

	/**
	 * 判断数组中是不是包含某个元素
	 */
	@Override
	public boolean contains(E e) {
		return indexOf(e) != -1;
	}
	
	/**
	 * 查找某个元素在数组的位置
	 */
	@Override
	public int indexOf(E e) {
		int ret = -1;
		if(e == null){
			Object object = null;
			for (int i = 0; i < size -1 ; i++) {
				object = element[i];
				if(object == e){
					ret = i;
					break;
				}
				
			}
		}else{
			Object obj = null;
			for (int i = 0; i < size -1 ; i++) {
				obj = element[i];
				if(e.equals(obj)){
					ret = i;
					break;
				}
				
			}
		}
		return ret;
	}

	/**
	 * 将指定位置设置为新的元素，并将该位置老的元素返回
	 */
	@Override
	public E set(int index, E element) {
		if(index > size || index < 0){
			throw new ArrayIndexOutOfBoundsException(index+"超过了数组的下标最大值");
		}
		
		E ret = (E) this.element[index];
		this.element[index] = element;
		return ret;
	}

	/**
	 * 获取指定索引位置的元素
	 */
	@Override
	public E get(int index) {
		if(index > size || index < 0){
			throw new ArrayIndexOutOfBoundsException(index+"超过了数组的下标最大值");
		}
		return (E) this.element[index];
	}

	/**
	 * 查找某一个元素最后一次出现的位置
	 */
	@Override
	public int lastIndexOf(E e) {
		int ret = -1;
		if(e == null){
			for (int i = size-1; i >0; i--) {
				if(e == element[i]){
					ret = i;
					break;
				}
			}
		}else{
			for (int i = size-1; i >0; i--) {
				if(e.equals(element[i])){
					ret = i;
					break;
				}
			}
		}
		return ret;
	}

	/**
	 * 判断数组是否为空
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
