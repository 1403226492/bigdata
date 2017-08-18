package com.zhiyou100.oop.enums;

public class Test {

	public static void main(String[] args) {
		int result = getMax(1,2,3,4,5,6,7,99,88,77,45,43);
		System.out.println(result);
	}
	
	public static int getMax(int... nums){
		int ret = 0;
//		for(int i=0;i<nums.length;i++){
//			if(nums[i] > ret){
//				ret = nums[i];
//			}
//		}
		
		for(int i : nums){
			if(i> ret){
				ret = i;
			}
		}
		return ret;
	}
}
