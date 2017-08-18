package com.zhiyou100.collections.homework.entity;

public class JuniorStudent {
	/**
	 * ѧ��
	 */
	private String serialNum;
	
	/**
	 * ѧ������
	 */
	private String name;
	
	/**
	 * ���ԵĿ�Ŀ
	 */
	private String subject;
	
	/**
	 * ���Գɼ�
	 */
	private double score;

	/**
	 * �Ӹ���ֱ�Ӽ̳еĹ��췽��,<br />
	 * �ڶ���ʵ���ʱ��Ϊ�˷��������ά��
	 * �Ϳ�ܵ�ע�룬���ÿ��ʵ���඼��һ���޲ε�
	 * ���췽����
	 */
	public JuniorStudent() {
		super();
	}

	/**
	 * @param serialNum ѧ��
	 * @param name ����
	 * @param subject ���Կ�Ŀ
	 * @param score ���Գɼ�
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
	 * ÿ�����󱻴�ӡ��ʱ��Ĭ�϶������toString����
	 * ��������õ��౾��û��ʵ��toString�������������
	 * �����toString������ֱ�����յ���Object���toString
	 * ������
	 */
	@Override
	public String toString() {
		return "JuniorStudent [serialNum=" + serialNum + ", name=" + name + ", subject=" + subject + ", score=" + score
				+ "]";
	}

	/**
	 * �÷������ڸ��������뵽HashSet��HashMap��Hashtable��
	 * ��ʱ������ȷ�϶������ŵ�λ�ã���equals�����䶯��ʱ�򣬸�
	 * ����Ҫ���ű䶯��
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
	 * ��д�����equals�����������д��equals�ͱ���Ҫ��д
	 * hashCode���������ڵ�ǰ��û����ʾ�ļ̳��κ��࣬��jvm
	 * Ĭ�ϼ̳�Object�ࡣ
	 * @param obj Ҫ�ȽϵĶ���
	 * @return boolean �Ƚ�֮��Ľ��
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
