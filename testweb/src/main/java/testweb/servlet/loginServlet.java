package testweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import file.file;
import testweb.dao.UserDAO;
import testweb.dao.messageDAO;
import testweb.dao.impl.UserDAOImpl;
import testweb.dao.impl.messageDAOImpl;
import testweb.dao.impl.uploadDAOImpl2;
import testweb.vo.UserInfo;
import testweb.vo.messageinfo;

public class loginServlet extends HttpServlet{
    public void doPost(HttpServletRequest reqa, HttpServletResponse resa) throws IOException, ServletException {
		    messageinfo messageInfo = new messageinfo();
		    UserInfo userinfo = new UserInfo();
		    UserInfo userinfo3 = new UserInfo();
		    userinfo.setUsername(reqa.getParameter("username"));
		    userinfo3.setUsername(reqa.getParameter("username"));
		    messageInfo.setUsername(reqa.getParameter("username"));
		    userinfo.setPassword(reqa.getParameter("password"));
		    messageDAO dao = new messageDAOImpl();
		    List<messageinfo> mess = new ArrayList<>(); 
		    UserDAO daoa1 = new uploadDAOImpl2();
		    String images ="5";
		    String pat="C:\\Users\\nexus\\eclipse-workspace\\testweb\\src\\main\\webapp\\images";
		    file file1 = new file();
         
            UserDAO daoa = new UserDAOImpl();
            int flag1 = 0;
	        
	        try {
	        	file1.insertPhoto(pat, messageInfo);

				mess = dao.queryBymessageInfo(messageInfo);
				flag1 = daoa.queryByUserInfo(userinfo);
				images= daoa1.queryByUserInfo3(userinfo3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        if (flag1 == 1) {
	        	//file1.insertPhoto(pat, messageInfo);
	            HttpSession session = reqa.getSession();
	            session.setAttribute("images", images);
	            session.setAttribute("mess", mess);
	            resa.sendRedirect("./usersmessage.jsp");
	        } else {
	            resa.sendRedirect("./error2.jsp");
	        }
	    }
}
