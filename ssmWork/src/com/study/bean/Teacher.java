package com.study.bean;

import java.util.Date;

public class Teacher {
	
	private Integer id;
	private String teacher;
	private String course;
	private String address;
	private Date date;
	public Teacher() {
		super();
	}
	public Teacher(Integer id, String teacher, String course, String address, Date date) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.course = course;
		this.address = address;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacher=" + teacher + ", course=" + course + ", address=" + address + ", date="
				+ date + "]";
	}
	
	

}
