package com.board.db.sqlconfig;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IBatisDBConnector {
	private static SqlMapClient mySQLMap;
	
	//DB 접속 설정파일 로드
	static
	{
		try {
			String resource = "com/board/db/sqlconfig/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			mySQLMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//인스턴스 반환
	public static SqlMapClient getSqlMapInstance() {
		return mySQLMap;
	}

}
