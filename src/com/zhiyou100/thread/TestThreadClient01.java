package com.zhiyou100.thread;

public class TestThreadClient01 {

	public static void main(String[] args) {
		ThreadDemo01 t1 = new ThreadDemo01();//����һ���߳�
		//t1.run();//�������ã���û���������̵߳�֧��
		t1.start();
		//t1.start();//�߳�ֻ������һ�Σ�������λ���ʾIllegalThreadStateException�쳣
		for(int j=0;j<10;j++){
			System.out.println("TestThreadClient01��ӡ��" + j);
		}
	}

}
