package testweb.dao;

import testweb.vo.*;

public interface UserDAO {
    public int queryByUserInfo(UserInfo userinfo) throws Exception;
    public int queryByUserInfo1(UserInfo userinfo) throws Exception;
    public int queryByUserInfo2(UserInfo userinfo) throws Exception;
    public int queryByUserInfo4(UserInfo userinfo5) throws Exception;
    public String queryByUserInfo3(UserInfo userinfo) throws Exception;
    
}
