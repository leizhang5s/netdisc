package cn.leizhang.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.leizhang.service.UserService;

public class UserExit extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		//System.out.println(username);
		UserService us=new UserService();
		
		try {
			boolean bl=us.ifExist(username);
			
			if(username.equals(""))
					{
				out.print("用户名不能为空");
					}
					
			else if(bl==true)
			{
				out.print("用户名已存在");
				
			}
			else
			{	
			
				out.print("");
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		out.flush();
		out.close();

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
		
	}
	
}
