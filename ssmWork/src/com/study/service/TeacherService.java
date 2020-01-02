package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.bean.Teacher;
import com.study.dao.TeacherDao;

@Service
public class TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	
	public Teacher getTeacher(Integer id) {
		Teacher teacherById = teacherDao.getTeacherById(1);
		return teacherById;
	}
	
	public List<Teacher> getTeachers(){
		return teacherDao.getTeachers();
	}
}
