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
		System.out.println("请输入开始");
		String thing1 = null;
		thing1 = thing.next();

		getRandom(thing1);
	}

	public static void getRandom(String things) {
		Random random = null;
		if (things.equals("开始")) {
			random = new Random();
			Integer random2 = random.nextInt(34) + 1;
			Map<Integer, String> map1 = new HashMap<Integer, String>();
			map1.put(1, "陈凯杰");
			map1.put(2, "王永森");
			map1.put(3, "陈升腾");
			map1.put(4, "徐志立");
			map1.put(5, "蒋玉凯");
			map1.put(6, "陈晓凯");
			map1.put(7, "张培");
			map1.put(8, "成全利");
			map1.put(9, "孙源");
			map1.put(10, "张型宇");
			map1.put(11, "王涛");
			map1.put(12, "桑国帅");
			map1.put(13, "邓振东");
			map1.put(14, "宋航琦");
			map1.put(15, "邹九龙");
			map1.put(16, "杨龙");
			map1.put(17, "靳林川");
			map1.put(18, "贺尤申");
			map1.put(19, "韩豫博");
			map1.put(20, "王中亚");
			map1.put(21, "刘继奎");
			map1.put(22, "侯亚坤");
			map1.put(23, "刘乐乐");
			map1.put(24, "吴腾龙");
			map1.put(25, "孙双明");
			map1.put(26, "郭帅");
			map1.put(27, "李银修");
			map1.put(28, "田亮亮");
			map1.put(29, "吕华磊");
			map1.put(30, "齐元迪");
			map1.put(31, "马杰");
			map1.put(32, "邓慧");
			map1.put(33, "杜羽");
			map1.put(34, "刘云鹏");
			Set<Integer> keySet = map1.keySet();
			File file = new File("记事本.txt");
			FileOutputStream fil = null;
			for (Integer integer = 0; integer < keySet.size(); integer++) {
				if (random2.equals(integer)) {
					System.out.println("产生一位幸运同学，你猜!");
					try {
						fil = new FileOutputStream(file, true);
						fil.write(new String(String.format("%1$tF,%1$tT", System.currentTimeMillis()) + " 今天的幸运同学是: "
								+ map1.get(integer) + " 为大家带来一首歌曲!" + "\r\n").getBytes());
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
			System.err.println("请您请输入'开始',才能进行抽取!");
		}

	}

}
