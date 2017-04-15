package cn.leizhang.servlet;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.leizhang.domain.User;
import cn.leizhang.service.UserService;

public class loginservlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			User user=new User();
			//调用javabean封装数据
		
				
			UserService us=new UserService();
			User user2;
			try {
				user2 = us.find_User(username,password);

				if(user2!=null)
				{
					
				try {
						request.setAttribute("username", user.getUsername());
					//request.getRequestDispatcher("/userManager.jsp?username="+user.getUsername()).forward(request, response);
					request.getRequestDispatcher("/userManager.jsp").forward(request, response);
				} catch (ServletException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				}
				else
				{
					
					try {
						request.setAttribute("error", "用户名或密码错误");
						//response.sendRedirect("/netdisc/login.jsp");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
			
				
				
			
					
					
			
			
				
			
			
				
				
			
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
		
	}
	
}

	