package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.bean.Teacher;
import com.study.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	
	@RequestMapping("test")
	public String test() {
		System.out.println("����bookService�Ƿ�װ��ɹ�"+teacherService);
		return "forward:/index.jsp";
	}
	
	@RequestMapping("/getTea")
	public String getTea(@RequestParam("id")Integer id,Model model) {
		Teacher teacher=teacherService.getTeacher(id);
		model.addAttribute("teacher", teacher);
		return "success";
	}
	
	@RequestMapping("/getTeaByPage")
	public String getTeaByPage(@RequestParam(value = "i",defaultValue = "1")Integer i,Model model) {
//		�������Ĳ�ѯ����һ����ҳ��ѯ
		PageHelper.startPage(i, 10);
		List<Teacher> teachers = teacherService.getTeachers();
//		�����ʱ��������һ�䣬��ô������ʾ����ȫ�������Ƿ�ҳ��Ľ��
//		List<Teacher> teachers = teacherService.getTeachers();
//		ʹ��PageInfo�Խ�����з�ҳ��ʾ
//		PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
//		�����ʾ��ҳ֮����ϣ������չʾ����ҳ
		PageInfo<Teacher> pageInfo = new PageInfo<>(teachers, 10);
		System.out.println("��ǰҳ��:"+pageInfo.getPageNum());
		System.out.println("��ҳ��:"+pageInfo.getPages());
		System.out.println("��ǰҳ�м�����¼:"+pageInfo.getSize());
		System.out.println("�ܼ�¼��:"+pageInfo.getTotal());
		System.out.println("��һҳ:"+pageInfo.getPrePage());
		System.out.println("��һҳ:"+pageInfo.getNextPage());
		System.out.println("���һ��:"+pageInfo.getEndRow());
		System.out.println("���У�"+pageInfo.getStartRow());
		System.out.println("��ѯ��������ͣ�"+pageInfo.getList());
//		��������ҳ��ҳ������һ�����鱣��
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		model.addAttribute("pageInfo", pageInfo);
		return "success";
	}
}
