package com.model;

import java.util.List;

public class Student {

	private static long maxId = 1;

	private long id;

	private String number;

	private String name;

	private String sex;

	private String specialty;

	private String department;

	private String image;

	private List<String> like;

	public static Long getMaxId( ) {
		return maxId ++;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the specialty
	 */
	public String getSpecialty(){return specialty;}

	/**
	 * @param specialty the specialty to set
	 */
	public void  setSpecialty(String specialty){this.specialty=specialty;}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the like
	 */
	public List<String> getLike() {
		return like;
	}

	/**
	 * @param like the like to set
	 */
	public void setLike(List<String> like) {
		this.like = like;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	public String getImageStr() {
		String img = "";
		if( "男".equals( sex )){
			img = Math.random() > 0.5 ? "/img/9901.png" : "/img/9903.png";
		}
		else{
			img = Math.random() > 0.5 ? "/img/9902.png" : "/img/9904.png";
		}
		return img;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}


}
