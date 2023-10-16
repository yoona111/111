package testweb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import testweb.dao.UserDAO;
import testweb.db.DBConnect;
import testweb.vo.UserInfo;

public class UserDAOImpl implements UserDAO {
	public int queryByUserInfo1(UserInfo userinfo) throws Exception{return 0;}
	public int queryByUserInfo2(UserInfo userinfo) throws Exception{return 0;}
	@Override
	public int queryByUserInfo(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		int flag1=0;
		String sql ="select * from userinfo where username=?";
		PreparedStatement pstmt =null;
		DBConnect dbc=null;
		
		try {
			dbc =new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,userinfo.getUsername());
			
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("password").equals(userinfo.getPassword())) {
					flag1 =1;
				}
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			dbc.close();
			}
			return flag1;
	}
	public String queryByUserInfo3(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		return "";
	}
	@Override
	public int queryByUserInfo4(UserInfo userinfo5) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

	
	


