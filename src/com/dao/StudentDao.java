package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.model.Student;



/**
 *
 * @author zhangsheng
 * 2021-04-12 16:48:34
 * <dl>
 * 		<dt>StudentDao</dt>
 *		<dd>学生类的数据访问类，实现学生信息的数据访问操作。</dd>
 * </dl>
 */
public class StudentDao implements DomainDaoInterface {
	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>插入一个学生对象</dd>
	 * </dl>
	 * @param obj 要插入的学生对象
	 * @param conn 操作数据库的连接
	 * @param pst 执行sql语句的statement
	 * @return 操作成功返回1，否则返回0
	 * @throws SQLException
	 */
	public int insert(Object obj,Connection conn,PreparedStatement pst)
			throws SQLException {

		int flag = 0;
		Student std = (Student) obj;

		String sql = " insert into student( "
	    		+ "  name , number "
	    		+ " , sex , likes,specialty, department "
	    		+ " ) values ("
	    		+ "  ?,?,?,?,?,? "
	    		+ " )";

		pst = conn.prepareStatement(sql);

		pst.setString(1, std.getName());
		pst.setString(2, std.getNumber());
		pst.setString(3, std.getSex());

		String likeStr = "";
		if( std.getLike() != null
				&& std.getLike().size() > 0) {
			likeStr = String.join(",", std.getLike()) ;
		}
		pst.setString(4, likeStr);
		pst.setString(5,std.getSpecialty());
		pst.setString( 6, std.getDepartment() );

		pst.execute();
		flag = 1;

		return flag;
	}
	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>插入一个学生记录</dd>
	 * </dl>
	 * @param obj 要插入的学生对象
	 * @return 操作成功返回1，否则返回0
	 * @see com.dao.DomainDaoInterface#insert(java.lang.Object)
	 */
	@Override
	public int insert(Object obj){
		int flag = 0;
		Connection conn = DBConfig.getConnection();
		PreparedStatement pst = null;
		try {
			flag = insert(obj, conn, pst);
		} catch (SQLException e) {
			System.out.println("Student: insert error");
			e.printStackTrace();
		}finally {
			DBConfig.closeConnection(null, pst, conn);
		}
		return flag;
	}

	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>从数据库表中删除该学生对象</dd>
	 * </dl>
	 * @param obj 要删除的学生对象
	 * @return 操作成功返回1，否则返回0
	 * @see com.dao.DomainDaoInterface#delete(java.lang.Object)
	 */
	@Override
	public int delete(Object obj) {
		int f = 0;
		Student std = (Student) obj;
		String sql = "delete from  student  "
	    		+ " where id = ? ";
	    Connection conn = DBConfig.getConnection();
	    PreparedStatement pstmt = null;
		try {
			try{
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, std.getId());
			}catch (SQLException e) {
				e.printStackTrace();
			}
			pstmt.execute();
			f = 1;
		} catch (SQLException e) {
			e.printStackTrace();

		}finally {
			DBConfig.closeConnection(null, pstmt, conn);
		}
		return f;
	}

	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>更新学生对象</dd>
	 * </dl>
	 * @param obj 要更新的学生对象
	 * @return 操作成功返回1，否则返回0
	 * @see com.dao.DomainDaoInterface#update(java.lang.Object)
	 */
	@Override
	public int update(Object obj)   {
		int f = 0;
		Student std = (Student) obj;

		String sql = "update student t set t.name = ? "
				+ " , t.number = ? "
				+ " , t.sex = ? "
				+ " , t.likes = ? "
				+ " , t.specialty = ? "
				+ " , t.department = ? "
	    		+ " where id = ? ";
	    Connection conn = DBConfig.getConnection();
	    PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			try {
				pstmt.setString(1, std.getName());
				pstmt.setString(2, std.getNumber());
				pstmt.setString(3, std.getSex());
				String likeStr = "";
				if( std.getLike() != null
						&& std.getLike().size() > 0) {
					likeStr = String.join(",", std.getLike()) ;
				}
				pstmt.setString(4, likeStr);
				pstmt.setString(5, std.getSpecialty());
				pstmt.setString( 6, std.getDepartment() );

				pstmt.setLong(7, std.getId());
			} catch (SQLException e) {
				System.out.println("update param error");
				e.printStackTrace();
			}
			pstmt.execute();
			f = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConfig.closeConnection(null, pstmt, conn);
		}
		return f;
	}

	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>根据学生id从表中获得学生对象</dd>
	 * </dl>
	 * @param objId 要查找的学生对象的id
	 * @return 学生对象，若表中没有对应信息，则返回null
	 * @see com.dao.DomainDaoInterface//findById(int)
	 */
	@Override
	public Object findById(long objId)   {

		String sql = "select * from  student  where id = ? ";
	    Connection conn = DBConfig.getConnection();
	    PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			try {
				pstmt.setLong(1, objId);
			} catch (SQLException e) {
				System.out.println("update param error");
				e.printStackTrace();
			}
			ResultSet rs = pstmt.executeQuery();
			List<Object> studentList = this.toModel(rs);
			if( studentList != null && studentList.size() == 1){
				return (Student) studentList.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConfig.closeConnection(null, pstmt, conn);
		}
		return null;
	}



	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>获得表中所有的学生记录</dd>
	 * </dl>
	 * @return 表中学生记录封装的学生列表
	 * @see com.dao.DomainDaoInterface#findAll()
	 */
	@Override
	public List<Object> findAll()   {

		String sql = "select * from  student  order by id desc ";
	    Connection conn = DBConfig.getConnection();
	    PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			List<Object> studentList = this.toModel(rs);
			if( studentList != null ){
				return studentList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConfig.closeConnection(null, pstmt, conn);
		}
		return null;
	}

	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>将记录集中的数据记录转换为学生对象列表</dd>
	 * </dl>
	 * @param rs
	 * @return
	 * @see com.dao.DomainDaoInterface#toModel(java.sql.ResultSet)
	 */
	@Override
	public List<Object> toModel(ResultSet rs){
		List<Object> studentList = new ArrayList();
		try {
			while(rs.next()){
				Student std = new Student();

				std.setId( rs.getLong("id") );
				std.setName( rs.getString("name") );
				std.setNumber( rs.getString("number") );
				std.setSex( rs.getString("sex") );
				std.setSpecialty(rs.getString("specialty"));
				std.setDepartment( rs.getString("department") );

				String likeStr = rs.getString("likes");

				if(likeStr != null && !"".equals(likeStr)) {
					String[] likeArr = likeStr.split(",");
					if( likeArr != null ) {
						std.setLike( Arrays.asList(likeArr) );
					}
				}
				studentList.add(std);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return studentList;
	}
	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>分页显示信息时，用来获得某一页的学生列表</dd>
	 * </dl>
	 * @param pageSize  页大小，即一页显示多少条学生信息
	 * @param pageNumber 页编号，即当前是第几页
	 * @return
	 */
	public List<Object> getPage(int pageSize,int pageNumber){
		String sql = "select * from  student  order by id "
				+ " limit ?,? ";
		Connection conn = DBConfig.getConnection();
	    PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageSize * (pageNumber-1));
			pstmt.setInt(2, pageSize);
			ResultSet rs = pstmt.executeQuery();
			List<Object> studentList = this.toModel(rs);
			if( studentList != null ){
				return studentList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConfig.closeConnection(null, pstmt, conn);
		}
		return null;
	}


	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>获得当前学生的总数。</dd>
	 * </dl>
	 * @return 返回学生总数。
	 */
	public int getCount() {
		String sql = "select count(*) cnt from  student ";
	    Connection conn = DBConfig.getConnection();
	    PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConfig.closeConnection(null, pstmt, conn);
		}
		return 0;
	}


}
