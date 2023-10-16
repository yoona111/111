package testweb.servlet;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import testweb.dao.UserDAO;
import testweb.dao.impl.uploadDAOImpl;
import testweb.vo.UserInfo;
@WebServlet("/UploadServlet")
@MultipartConfig
public class upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	int rowsInserted=0;
    	String base64Image="5";
    	String base64Image1="800";
        UserInfo userinfo5 = new UserInfo();
        userinfo5.setUsername(request.getParameter("username3"));
        Part filePart = request.getPart("file");
		InputStream fileContent = filePart.getInputStream();
		byte[] imageDataBytes = fileContent.readAllBytes();
        base64Image = Base64.getEncoder().encodeToString(imageDataBytes);
		//base64Image = new String(fileData);
		
		userinfo5.setimageData(base64Image);
		UserDAO daoa = new uploadDAOImpl();
		
		try {
			rowsInserted = daoa.queryByUserInfo4(userinfo5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rowsInserted > 0) {
		    request.setAttribute("message", "上传成功");
		    request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
		    request.setAttribute("message", "上传失败");
		    request.getRequestDispatcher("2.jsp").forward(request, response);
		}

        // 重定向回上传页面或其他页面
        //request.getRequestDispatcher("upload_result.jsp").forward(request, response);
    }
}

