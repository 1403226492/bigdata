package com.zhiyou100.collections.list;

public interface IList<E> {
	int size();
	boolean add(E e);
	boolean remove(E e);
	boolean remove(int i);
	boolean contains(E e);
	int indexOf(E e);
	E set(int index, E element);
	E get(int index);
	int lastIndexOf(E e);
	boolean isEmpty();
	
}
