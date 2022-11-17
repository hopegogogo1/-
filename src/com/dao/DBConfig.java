package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 
 * @author zhangsheng 
 * 2021-04-12 13:11:2
 * <dl>
 * 		<dt>DBConfig</dt>
 *		<dd>数据库连接和关闭工具类</dd>
 * </dl>
 */
public class DBConfig {

	/** 数据库连接地址 */
	private static String URL;

	/** 数据库用户名 */
	private static String USERNAME;

	/** 数据库密码 */
	private static String USERPASSWORD;

	/** mysql 驱动 */
	private static String DRIVER;

	/** 数据库配置信息*/
	private static ResourceBundle rb = ResourceBundle
			.getBundle("com.dao.db-config");

	/**
	 * 使用静态代码块加载驱动
	 */
	static {
		URL = rb.getString("jdbc.url");
		USERNAME = rb.getString("jdbc.username");
		USERPASSWORD = rb.getString("jdbc.userpassword");
		DRIVER = rb.getString("jdbc.driver");

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver error");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>获得数据库连接</dd>
	 * </dl>
	 * @return 数据库连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
		} catch (SQLException e) {
			System.out.println("Get Connection error");
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>关闭数据库连接</dd>
	 * </dl>
	 * @param rs 要释放的结果集
	 * @param ps 要释放的statement
	 * @param conn 要释放的数据库连接
	 */
	public static void closeConnection(ResultSet rs, Statement ps,
			Connection conn) {
		try {
			if (null != rs)
				rs.close();
			if (null != ps)
				ps.close();
			if (null != conn)
				conn.close();
		} catch (SQLException e) {
			System.out.println("Close Connection error");
			e.printStackTrace();
		}
	}
}