package com.zhiyou100.net;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class testRandom {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner thing = new Scanner(System.in);
		System.out.println("�����뿪ʼ");
		String thing1 = null;
		thing1 = thing.next();

		getRandom(thing1);
	}

	public static void getRandom(String things) {
		Random random = null;
		if (things.equals("��ʼ")) {
			random = new Random();
			Integer random2 = random.nextInt(34) + 1;
			Map<Integer, String> map1 = new HashMap<Integer, String>();
			map1.put(1, "�¿���");
			map1.put(2, "����ɭ");
			map1.put(3, "������");
			map1.put(4, "��־��");
			map1.put(5, "����");
			map1.put(6, "������");
			map1.put(7, "����");
			map1.put(8, "��ȫ��");
			map1.put(9, "��Դ");
			map1.put(10, "������");
			map1.put(11, "����");
			map1.put(12, "ɣ��˧");
			map1.put(13, "����");
			map1.put(14, "�κ���");
			map1.put(15, "�޾���");
			map1.put(16, "����");
			map1.put(17, "���ִ�");
			map1.put(18, "������");
			map1.put(19, "��ԥ��");
			map1.put(20, "������");
			map1.put(21, "���̿�");
			map1.put(22, "������");
			map1.put(23, "������");
			map1.put(24, "������");
			map1.put(25, "��˫��");
			map1.put(26, "��˧");
			map1.put(27, "������");
			map1.put(28, "������");
			map1.put(29, "������");
			map1.put(30, "��Ԫ��");
			map1.put(31, "���");
			map1.put(32, "�˻�");
			map1.put(33, "����");
			map1.put(34, "������");
			Set<Integer> keySet = map1.keySet();
			File file = new File("���±�.txt");
			FileOutputStream fil = null;
			for (Integer integer = 0; integer < keySet.size(); integer++) {
				if (random2.equals(integer)) {
					System.out.println("����һλ����ͬѧ�����!");
					try {
						fil = new FileOutputStream(file, true);
						fil.write(new String(String.format("%1$tF,%1$tT", System.currentTimeMillis()) + " ���������ͬѧ��: "
								+ map1.get(integer) + " Ϊ��Ҵ���һ�׸���!" + "\r\n").getBytes());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							fil.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}else {
			System.err.println("����������'��ʼ',���ܽ��г�ȡ!");
		}

	}

}
