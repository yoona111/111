package testweb.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import testweb.dao.messageDAO;
import testweb.db.DBConnectmessage;
import testweb.vo.messageinfo;
import java.util.Base64;

public class messageDAOImpl implements messageDAO{

	@Override
	public List<messageinfo> queryBymessageInfo(messageinfo messageInfo) throws Exception {
		// TODO Auto-generated method stub
		List<messageinfo> strings= new ArrayList<>();	
		String sql ="select * from message where username=?";
		PreparedStatement pstmt =null;
		DBConnectmessage dbc=null;
		
		
		try {
			dbc =new DBConnectmessage();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1,messageInfo.getUsername());
			
			ResultSet rs =pstmt.executeQuery();
			while(rs.next()) {
				messageinfo messageInfo1 = new messageinfo();
				messageInfo1.setUsername(rs.getString("username"));
				messageInfo1.setimage(rs.getString("image"));
				strings.add(messageInfo1);
				
			}
			rs.close();
			pstmt.close();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			dbc.close();
			}
		  return strings;
	}
	

}

