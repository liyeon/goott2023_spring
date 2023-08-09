package com.tech.db;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBCon {
	// 디비접속을 해보자아
	static Connection conn;
	public static Connection getConnection() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/springxe");
			conn=dataSource.getConnection();
		} catch (Exception e) {
			System.out.println("디비 접속 오류 >>> ");
			e.printStackTrace();
		}
		return conn;
	}
}