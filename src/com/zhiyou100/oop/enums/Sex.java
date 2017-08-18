package com.zhiyou100.oop.enums;

public enum Sex{
	MALE("ÄÐ"),FAMALE("Å®"),UNKNOWN("Î´Öª");
	
	private String sexName;
	private Sex() {
	}
	private Sex(String sexName) {
		this.sexName = sexName;
	}
	public String getSexName() {
		return sexName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer("[");
		sb.append("sexName=" + sexName);
		sb.append("]");
		return sb.toString();
	}
	
	public String getEnumChineseName(){
		return sexName;
	}
}
