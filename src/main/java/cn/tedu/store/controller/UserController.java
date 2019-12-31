package cn.tedu.store.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.UserNameAlreadyExistException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private IUserService userService;
	
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/showPersonInfo.do")
	public String showPersonInfo() {
		return "personInfo";
	}
	
	@RequestMapping("/showPassword.do")
	public String showPassword() {
		return "personal_password";
	}
	
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		//1.让session失效
		session.invalidate();
		//2.重定向到index
		return "redirect:/main/showIndex.do";
	}
	
	//用户名文本框失去焦点的控制器方法
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		//1.创建rr对象
		//2.调用业务层方法：checkUsername；返回b
		//3.如果b==true，设置state：1，message：“用户名可以使用”
		//4.b==false，设置state：0，message：“用户名不可使用”
		//return rr；
		ResponseResult<Void> rr = new ResponseResult<Void>();
		boolean b = userService.checkUsername(username);
		if (b) {
			rr.setState(1);
			rr.setMessage("用户名可以使用");
		}else {
			rr.setState(0);
			rr.setMessage("用户名不可以使用");
		}
		return rr;
	}
	
	//邮箱文本框失去焦点的控制器方法
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		//1.创建rr对象
		//2.调用业务层方法：checkEmail；返回b
		//3.如果b==true，设置state：1，message：“邮箱可以使用”
		//4.b==false，设置state：0，message：“邮箱不可使用”
		//return rr；
		ResponseResult<Void> rr = new ResponseResult<Void>();
		boolean b = userService.checkEmail(email);
		if (b) {
			rr.setState(1);
			rr.setMessage("邮箱可以使用");
		}else {
			rr.setState(0);
			rr.setMessage("邮箱不可以使用");
		}
		return rr;
	}
	
	//电话文本框失去焦点的控制器方法
		@RequestMapping("/checkPhone.do")
		@ResponseBody
		public ResponseResult<Void> checkPhone(String phone){
			//1.创建rr对象
			//2.调用业务层方法：checkEmail；返回b
			//3.如果b==true，设置state：1，message：“电话可以使用”
			//4.b==false，设置state：0，message：“电话不可使用”
			//return rr；
			ResponseResult<Void> rr = new ResponseResult<Void>();
			boolean b = userService.checkPhone(phone);
			if (b) {
				rr.setState(1);
				rr.setMessage("该手机号可以使用");
			}else {
				rr.setState(0);
				rr.setMessage("该手机号已经被占用");
			}
			return rr;
		}

		//提交按钮的控制器方法
		@RequestMapping("/register.do")
		@ResponseBody
		public ResponseResult<Void> register(@RequestParam("uname") String username,
																	@RequestParam("upwd") String password,
																	String email,String phone){
			//1.创建rr对象
			ResponseResult<Void> rr = new ResponseResult<Void>();
			try {
				//调用业务层方法register(user),state:1,message:注册成功
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				user.setPhone(phone);
				
				userService.register(user);
				
				rr.setState(1);
				rr.setMessage("注册成功");
			} catch (UserNameAlreadyExistException e) {
				//state:0,message:e.getMessage()
				rr.setState(0);
				rr.setMessage(e.getMessage());
			}
			return rr;
		}
		
		//定义提交按钮的控制器的方法
		@RequestMapping("/login.do")
		@ResponseBody
		public ResponseResult<Void> login(@RequestParam("lname") String username,
																@RequestParam("lwd") String password,
																HttpSession session){
			//1.创建rr
			//2.try{调用业务层方法login，state：1，message：登录成功
			//  把user对象设置到session中
			//			}catch(runtimeException){state:0,message:e.getMessage()}
			//3.return rr
			ResponseResult<Void> rr =
					new ResponseResult<Void>();
			try {
			   User user = userService.login(username, password);
			   rr.setState(1);
			   rr.setMessage("登录成功");
			   session.setAttribute("user", user);
			} catch (RuntimeException e) {
				rr.setState(0);
				rr.setMessage(e.getMessage());
			}
			return rr;
		}
		
		@RequestMapping("/updateUser.do")
		@ResponseBody
		public ResponseResult<Void> updateUser(HttpSession session,String username,
				Integer gender,String email,String phone){
			//1.创建rr对象
			//2.调用业务层方法updateuser（）
			//3.处理异常
			//4.return rr;
			ResponseResult<Void> rr = new ResponseResult<Void>();
			try {
				userService.updateUser(this.getId(session), username, gender, email, phone);
				rr.setState(1);
				rr.setMessage("保存修改对象成功");
				User user = userService.getUserById(this.getId(session));
				session.setAttribute("user", user);
			} catch (RuntimeException e) {
				rr.setState(0);
				rr.setMessage(e.getMessage());
			}
			return rr;
		}
		
		@RequestMapping("/updatePassword.do")
		@ResponseBody
		public ResponseResult<Void> updatePassword(HttpSession session,
															String oldPassword,
															String newPassword){
			ResponseResult<Void> rr =
					new ResponseResult<Void>();
			try {
				userService.changePassword(this.getId(session), oldPassword, newPassword);
				rr.setState(1);
				rr.setMessage("密码修改成功");
			} catch (RuntimeException e) {
				rr.setState(0);
				rr.setMessage(e.getMessage());
			}
			return rr;
		}
}
