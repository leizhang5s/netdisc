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
			//String username=request.getParameter("username");
			//String password=request.getParameter("password");
			User user=new User();
			//调用javabean封装数据
		
				BeanInfo info;
				try {
					info = Introspector.getBeanInfo(user.getClass());
					// 获取属性的描述
					PropertyDescriptor [] pds = info.getPropertyDescriptors();
					// 循环遍历，获取属性的名称
					for (PropertyDescriptor pd : pds) {
						// System.out.println(pd.getName());
						if(!"class".equals(pd.getName())){
							// 获取写的方法
							Method m = pd.getWriteMethod();
							try {
								m.invoke(user, request.getParameter(pd.getName()));
							} catch (IllegalArgumentException e) {
								
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								
								e.printStackTrace();
							}
						}
					}
				} catch (IntrospectionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			UserService us=new UserService();
					boolean bl;
					
				try {
					bl = us.find_User(user);
					if(bl==true)
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
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
			
					
					
			
			
				
			
			
				
				
			
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
		
	}
	
}

	