package file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import testweb.db.DBConnect;
import testweb.vo.messageinfo;
public class file
{

    public void insertPhoto(String path, messageinfo messageInfo)
    {
    	DBConnect dbc=null;
    	dbc =new DBConnect();
        Connection connection = dbc.getConnection();
        File file = new File(path);
        //获取该path下的所有的文件
        String[] photoName = file.list();
        
        PreparedStatement pstmt1 =null;
        PreparedStatement pstmt = null;
        
        int num = 0;
        
        try
        {
            String sql ="insert into message(image,username,fileName) values(?,?,?)";
            String sql1 ="select * from message where fileName=?";
            String fileName = "";
            String pn = "";
            int a=0;
            for (int i = 0; i < photoName.length; i++)
            {
            	pstmt = connection.prepareStatement(sql);
                pn = photoName[i];
                fileName = getFileName(pn);
                File file2 = new File(path + "\\" + pn);
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file2));
    			pstmt1 = dbc.getConnection().prepareStatement(sql1);
    			pstmt1.setString(1,fileName);
    			ResultSet rs =pstmt1.executeQuery();
    			if(rs.next()) 
    			{
    				a=1;
    			}
    			else
    			{
                pstmt.setString(1, "./images/"+ fileName+".jpg");
                pstmt.setString(2, messageInfo.getUsername());
                pstmt.setString(3,  fileName);
                pstmt.executeUpdate();
    			}
    			rs.close();
    			pstmt.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            
            dbc.close();
        }
    }
    
    public String getFileName(String pn)
    {
        String fileName = "";
        //照片名包含括号的，已括号分隔，，例如 123（张三）.jpg  截取后取的值是123
        if (pn.contains("（"))
        {
            fileName = pn.split("（")[0];
        }
        //照片名   例如 123.jpg  截取后取的值是123
        else if (pn.contains(".jpg"))
        {
            fileName = pn.split(".jpg")[0];
        }
        //照片名   例如 123.JPG  截取后取的值是123
        else if (pn.contains(".JPG"))
        {
            fileName = pn.split(".JPG")[0];
        }
        //如果以上不符合    默认 取值为 照片名+格式    例如：123.png
        else
        {
            fileName = pn;
        }
        
        return fileName;
    }
}