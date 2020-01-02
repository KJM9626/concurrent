package com.study.dao;

import java.util.List;

import com.study.bean.Teacher;

public interface TeacherDao {

	public Teacher getTeacherById(Integer id);
	
	public List<Teacher> getTeachers();

}
