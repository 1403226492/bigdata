package com.zhiyou100.thread.procon3;

public class Client {

	public static void main(String[] args) {
	Container container = new Container();
	
	Producer p1 = new Producer(container,"����");
	Producer p2 = new Producer(container,"����");
	Consumer c1 = new Consumer(container,"����");
	Consumer c2 = new Consumer(container,"����");
	new Thread(c1).start();
	new Thread(c2).start();
	new Thread(p1).start();
	new Thread(p2).start();
	
	}

}

