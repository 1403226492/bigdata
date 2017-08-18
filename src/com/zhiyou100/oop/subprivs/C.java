package com.zhiyou100.oop.subprivs;

import com.zhiyou100.oop.privs.A;

public class C extends A{
	@Override
	protected void protectedMethod() {
		super.protectedMethod();
	}
	public static void main(String[] args) {
		C c = new C();
		c.protectedMethod();
	}
}
