package com.zhiyou100.collections.homework.entity;

public class JuniorStudent {
	/**
	 * 学号
	 */
	private String serialNum;
	
	/**
	 * 学生姓名
	 */
	private String name;
	
	/**
	 * 考试的科目
	 */
	private String subject;
	
	/**
	 * 考试成绩
	 */
	private double score;

	/**
	 * 从父类直接继承的构造方法,<br />
	 * 在定义实体的时候，为了方便后续的维护
	 * 和框架的注入，最好每个实体类都有一个无参的
	 * 构造方法。
	 */
	public JuniorStudent() {
		super();
	}

	/**
	 * @param serialNum 学号
	 * @param name 姓名
	 * @param subject 考试科目
	 * @param score 考试成绩
	 */
	public JuniorStudent(String serialNum, String name, String subject, double score) {
		this.serialNum = serialNum;
		this.name = name;
		this.subject = subject;
		this.score = score;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * 每个对象被打印的时候，默认都会调用toString方法
	 * 如果被调用的类本身没有实现toString方法，则调用其
	 * 父类的toString方法，直到最终调用Object类的toString
	 * 方法。
	 */
	@Override
	public String toString() {
		return "JuniorStudent [serialNum=" + serialNum + ", name=" + name + ", subject=" + subject + ", score=" + score
				+ "]";
	}

	/**
	 * 该方法会在该类对象插入到HashSet，HashMap，Hashtable中
	 * 的时候用来确认对象所放的位置；当equals方法变动的时候，该
	 * 方法要跟着变动。
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((serialNum == null) ? 0 : serialNum.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}
	
	/**
	 * 重写父类的equals方法，如果重写了equals就必须要重写
	 * hashCode方法。由于当前类没有显示的继承任何类，则jvm
	 * 默认继承Object类。
	 * @param obj 要比较的对象
	 * @return boolean 比较之后的结果
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JuniorStudent other = (JuniorStudent) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (serialNum == null) {
			if (other.serialNum != null)
				return false;
		} else if (!serialNum.equals(other.serialNum))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
}
