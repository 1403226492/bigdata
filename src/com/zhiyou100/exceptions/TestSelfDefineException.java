package com.zhiyou100.exceptions;

public class TestSelfDefineException {

	public static void main(String[] args) {
		TestSelfDefineException tsde = new TestSelfDefineException();
		try {
			tsde.register(40);
		} catch (AgeExceedLimitException e) {
			e.printStackTrace();
			System.out.println("ע���û�������Ϊ��" + e.getAge() +"�꣬ע��Ч����" + e.getMessage());
		}
	}

	public  void register(int age) throws AgeExceedLimitException{
		if(age <= 15){
			throw new AgeExceedLimitException("�������̫С�ˣ������ʰɣ�", 15);
		}
		else if(age>= 35){
			throw new AgeExceedLimitException("�϶�������ô������ˣ�����˼��?",age);
		}else{
			System.out.println("������������ʣ�������������֮�ã�");
		}
	}
}
