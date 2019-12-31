package cn.tedu.store.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAOP {
	//
	@Before("bean(userService)")
	public void test1() {
		System.out.println("方法执行之前....");
	}
	//
	@After("bean(userService)")
	public void test2() {
		System.out.println("方法执行之后....");
	}
	
	//再业务方法没有异常时，执行该通知
	@AfterReturning("bean(userService)")
	public void test3() {
		System.out.println("方法之后执行。。。。afterReturning");
	}
	

}
