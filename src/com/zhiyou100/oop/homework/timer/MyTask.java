package com.zhiyou100.oop.homework.timer;

import java.util.TimerTask;

public class MyTask extends TimerTask {

	@Override
	public void run() {
		System.out.println(String.format("%1$tF %1$tT", System.currentTimeMillis()));
	}

}
