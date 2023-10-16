package testweb.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testweb.dao.UserDAO;
import testweb.dao.impl.registeredImpl;
import testweb.vo.UserInfo;

public class registeredServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		    UserInfo userinfo2 = new UserInfo();
		    userinfo2.setUsername(request.getParameter("username1"));
		    userinfo2.setPassword(request.getParameter("password1"));
		    userinfo2.setnumber(request.getParameter("number"));
		    // 将数据插入数据库
		    UserDAO daoa = new registeredImpl();
		    int flag1 = 0;
		    
		    try {
				flag1 = daoa.queryByUserInfo1(userinfo2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    // 可选：重定向到另一个页面或显示成功消息
		    if (flag1 == 0) {
		    	response.sendRedirect("./success.jsp");
	        } else {
	        	response.sendRedirect("./error.jsp");
	        }
	}}
