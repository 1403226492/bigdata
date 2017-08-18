package com.zhiyou100.exceptions;

public class TestSelfDefineException {

	public static void main(String[] args) {
		TestSelfDefineException tsde = new TestSelfDefineException();
		try {
			tsde.register(40);
		} catch (AgeExceedLimitException e) {
			e.printStackTrace();
			System.out.println("注册用户的年龄为：" + e.getAge() +"岁，注册效果：" + e.getMessage());
		}
	}

	public  void register(int age) throws AgeExceedLimitException{
		if(age <= 15){
			throw new AgeExceedLimitException("你的年龄太小了，不合适吧！", 15);
		}
		else if(age>= 35){
			throw new AgeExceedLimitException("老东西，这么大年纪了，有意思吗?",age);
		}else{
			System.out.println("你的年龄正合适，请享受你的配对之旅！");
		}
	}
}
