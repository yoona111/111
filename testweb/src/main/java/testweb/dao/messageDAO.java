package testweb.dao;

import java.util.List;

import testweb.vo.*;

public interface messageDAO {
	public List<messageinfo> queryBymessageInfo(messageinfo messageInfo) throws Exception;
		
	}

