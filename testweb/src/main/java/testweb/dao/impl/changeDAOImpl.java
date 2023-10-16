package testweb.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import testweb.dao.UserDAO;
import testweb.db.DBConnect;
import testweb.vo.UserInfo;
public class changeDAOImpl implements UserDAO{
	public int queryByUserInfo1(UserInfo userinfo) throws Exception{return 0;}
	public int queryByUserInfo(UserInfo userinfo) throws Exception{return 0;}
	@Override
	public int queryByUserInfo2(UserInfo userinfo3) throws Exception {
		// TODO Auto-generated method stub
		String sql1 ="select * from userinfo where username=?";
		String sql3 ="UPDATE userinfo SET password = ? WHERE username = ? AND tellphonenumber = ?";
		int flag3=0;
		boolean isDuplicate = false;
		PreparedStatement pstmt1 =null;
		PreparedStatement pstmt2 =null;
		DBConnect dbc=null;
		
		try {
			
			dbc =new DBConnect();
			pstmt1 = dbc.getConnection().prepareStatement(sql1);
			pstmt1.setString(1,userinfo3.getUsername());
			ResultSet rs =pstmt1.executeQuery();
			
			
			if(rs.next()) 
			{
				if(rs.getString("tellphonenumber").equals(userinfo3.getnumber())) {
					isDuplicate = true;
				}
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
				 dbc =new DBConnect();
					pstmt2 = dbc.getConnection().prepareStatement(sql3);
					pstmt2.setString(1,userinfo3.getPassword());
					pstmt2.setString(2,userinfo3.getUsername());
					pstmt2.setString(3,userinfo3.getnumber());
					pstmt2.executeUpdate();
					pstmt2.close();
			} 
			else {
				try 
				{
					flag3=1;
				}finally 
				{
					dbc.close();
					}
				
			}
                    return flag3;
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

