package testweb.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import testweb.dao.UserDAO;
import testweb.db.DBConnect;
import testweb.vo.UserInfo;
public class uploadDAOImpl implements UserDAO {
	@Override
    public int queryByUserInfo(UserInfo userinfo) throws Exception{return 0;}
	public int queryByUserInfo2(UserInfo userinfo) throws Exception{return 0;}
	public int queryByUserInfo4(UserInfo userinfo5) throws Exception {
		// TODO Auto-generated method stub
		String sql1 ="select * from userinfo where username=?";
		String sql3 ="UPDATE userinfo SET images = ? WHERE username = ?";
		int flag3=1;
		boolean isDuplicate = false;
		PreparedStatement pstmt1 =null;
		PreparedStatement pstmt2 =null;
		DBConnect dbc=null;
		
		try {
			
			dbc =new DBConnect();
			pstmt1 = dbc.getConnection().prepareStatement(sql1);
			pstmt1.setString(1,userinfo5.getUsername());
			ResultSet rs =pstmt1.executeQuery();
			if(rs.next()) 
			{
				isDuplicate = true;
				
			}
			rs.close();
	        pstmt1.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			dbc.close();
			}
		
		if (isDuplicate) 
		{
			try 
	     {
			    dbc =new DBConnect();
				pstmt2 = dbc.getConnection().prepareStatement(sql3);
				pstmt2.setString(1,userinfo5.getimageData());
				pstmt2.setString(2,userinfo5.getUsername());
				pstmt2.executeUpdate();
	            pstmt2.close();
	            }
	       catch(SQLException e)
			{
			System.out.println(e.getMessage());
		    }
			finally {
			dbc.close();
			}
		}
		else 
		{ 
	    	   flag3=0;
		}
		
                    return flag3;
	}
	@Override
	public int queryByUserInfo1(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String queryByUserInfo3(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		return "";
	}
	}