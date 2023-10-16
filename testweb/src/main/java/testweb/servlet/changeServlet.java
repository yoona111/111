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
import testweb.dao.impl.UserDAOImpl;
import testweb.dao.impl.changeDAOImpl;
import testweb.vo.UserInfo;
public class changeServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
	    
	    UserInfo userinfo3 = new UserInfo();
	    userinfo3.setUsername(request1.getParameter("username2"));
	    userinfo3.setnumber(request1.getParameter("number2"));
	    userinfo3.setPassword(request1.getParameter("password2"));
	    // 将数据插入数据库
	    UserDAO daoaa = new changeDAOImpl();
	    int flag3 = 0;
	    
	    try {
			flag3 = daoaa.queryByUserInfo2(userinfo3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // 可选：重定向到另一个页面或显示成功消息
	    if (flag3 == 1) {
	    	response1.sendRedirect("./changeerror.jsp");
        } else {
        	response1.sendRedirect("./login.jsp");
        }
}
}

