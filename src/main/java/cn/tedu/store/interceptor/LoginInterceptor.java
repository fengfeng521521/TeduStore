package cn.tedu.store.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
//执行控制器方法之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1.获取session对象
		HttpSession session = request.getSession();
		//2.从session对象中获取属性user；判断是否为空
		Object obj = session.getAttribute("user");
		//3.object obj = session.getAttribute("user");如果obj为空，重定向到登录页面,并且返回false；否则返回true
		if (obj==null) {
			String path = request.getContextPath();
			response.sendRedirect(path+"/user/showLogin.do");
			return false;
		}
		return true;
	}
//响应视图之前执行
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
//响应视图成功之后执行
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
