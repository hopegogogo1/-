package com.data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Student;

public class StudentData {
	
	public static List<Student> getInitStudentList(){
		List<Student> stdList = new ArrayList<Student>();
		stdList.add( StudentData.getZhangSan() );
		stdList.add( StudentData.getLiSi() );
		stdList.add( StudentData.getWangWu() );
		stdList.add( StudentData.getZhaoLiu() );
		return stdList;
	}

	/**
	 * 
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>获得学生赵柳对象</dd>
	 * </dl>
	 * @return 学生对象
	 */
	public static Student getZhaoLiu() {
		Student std = new Student();
		List<String> likeList = new ArrayList<String>();
		likeList.add( "音乐");
		likeList.add( "运动");
		//likeList.add( "读书");
		likeList.add( "学习");
		
		
		std.setId( Student.getMaxId() );
		std.setNumber( "192056104" );
		std.setName( "赵柳" );
		std.setSex( "男" );
		std.setDepartment( "计算机工程系" );
		std.setImage( "/img/9903.png" );
		std.setLike( likeList );
		return std;
	}
	
	public static Student getLiSi() {
		Student std = new Student();
		List<String> likeList = new ArrayList<String>();
		//likeList.add( "音乐");
		likeList.add( "运动");
		likeList.add( "读书");
		likeList.add( "学习");
		
		std.setId( Student.getMaxId() );
		std.setNumber( "192056103" );
		std.setName( "李思" );
		std.setSex( "女" );
		std.setDepartment( "计算机工程系" );
		std.setImage( "/img/9904.png" );
		std.setLike( likeList );
		return std;
	}
	
	public static Student getWangWu() {
		Student std = new Student();
		List<String> likeList = new ArrayList<String>();
		likeList.add( "音乐");
		//likeList.add( "运动");
		likeList.add( "读书");
		likeList.add( "学习");
		
		std.setId( Student.getMaxId() );
		std.setNumber( "192056102" );
		std.setName( "王武" );
		std.setSex( "男" );
		std.setDepartment( "计算机工程系" );
		std.setImage( "/img/9901.png" );
		std.setLike( likeList );
		return std;
	}
	
	public static Student getZhangSan() {
		Student std = new Student();
		List<String> likeList = new ArrayList<String>();
		likeList.add( "音乐");
		likeList.add( "运动");
		likeList.add( "读书");
		likeList.add( "学习");
		
		std.setId( Student.getMaxId() );
		std.setNumber( "192056101" );
		std.setName( "张伞" );
		std.setSex( "女" );
		std.setDepartment( "计算机工程系" );
		std.setImage( "/img/9902.png" );
		std.setLike( likeList );
		return std;
	}
}
