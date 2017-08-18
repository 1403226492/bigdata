package com.zhiyou100.collections.list;

import java.util.Arrays;

public class HybList<E> implements IList<E> {
	private Object[] element;
	
	/*
	 * size������¼��������ʵ���ݵĸ�������Ϊ���ǵ�������
	 * ��̬�����ģ���������֮������ĺ�����û�����ݵģ����ʱ��
	 * �������鱣�������������sizeҪ��¼�ĸ�����
	 * sizeĬ�ϸ�ֵΪ0�����û����ʾ��ֵ�����õ���ÿ�������ڳ�ʼ����
	 * ʱ��byte��short��int��long��Ĭ�ϳ�ʼֵΪ0����������ط�ֱ��������
	 * ������new��ʱ�򣬳�ʼֵĬ���Ѿ�����ֵΪ0�ˡ�
	 */
	private int size;
	
	private static final int DEFAULT_INIT_SIZE = 10;
	 
	/**
	 * ʹ��Ĭ�ϵĳ�ʼ��������10������ʼ������
	 */
	public HybList() {
		this(DEFAULT_INIT_SIZE);
	}
	
	/**
	 * ʹ��ָ���ĳ�ʼ��������ʼ������
	 * @param capacity
	 */
	public HybList(int capacity) {
		if(capacity < 0){
			throw new ArrayIndexOutOfBoundsException("�����±꣺" + capacity +"������������±���Сֵ");
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
	 * ���Ҫ�����Ԫ��λ���Ƿ񳬹�Ŀǰ�ײ����������±꣬
	 * ����Ѿ�������������ĳ�������2����
	 * @param i
	 */
	private void checkArraySize(int i) {
		int oldLength = element.length;
		if(i > oldLength){
			/*
			 * Ϊ�˷�ֹ�����ռ��������鸳ֵ�Ĺ�����
			 * ��ԭ�������е����ݸ����յ���������һ������
			 * ռ��λ�á�
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
			throw new ArrayIndexOutOfBoundsException(i+"������������±����ֵ");
		}
		
		//element[i] = null;
		/*
		 * ������ʾi�����Ҫ�ƶ��ĸ���������������±��Ǵ�0��ʼ��
		 * ����Ҫ��ȥ��1
		 */
		int moveCount = size - i -1;
		System.arraycopy(element, i+1, element, i, moveCount);
		size--;
		return true;
	}

	/**
	 * �ж��������ǲ��ǰ���ĳ��Ԫ��
	 */
	@Override
	public boolean contains(E e) {
		return indexOf(e) != -1;
	}
	
	/**
	 * ����ĳ��Ԫ���������λ��
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
	 * ��ָ��λ������Ϊ�µ�Ԫ�أ�������λ���ϵ�Ԫ�ط���
	 */
	@Override
	public E set(int index, E element) {
		if(index > size || index < 0){
			throw new ArrayIndexOutOfBoundsException(index+"������������±����ֵ");
		}
		
		E ret = (E) this.element[index];
		this.element[index] = element;
		return ret;
	}

	/**
	 * ��ȡָ������λ�õ�Ԫ��
	 */
	@Override
	public E get(int index) {
		if(index > size || index < 0){
			throw new ArrayIndexOutOfBoundsException(index+"������������±����ֵ");
		}
		return (E) this.element[index];
	}

	/**
	 * ����ĳһ��Ԫ�����һ�γ��ֵ�λ��
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
	 * �ж������Ƿ�Ϊ��
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
