package com.zhiyou100.oop.homework.timer;

import java.util.Date;
import java.util.Timer;

public class TestTimer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new MyTask(), new Date(), 1000);
	}
}
