package com.zhiyou100.reflection.staticproxy;

/**
 * 抽象主题，用来标示整个系统需要完成的任务
 * @author ayuw
 *
 */
public interface IWoman {
	void sendMsg(String target);
	void happy(String target);
}
