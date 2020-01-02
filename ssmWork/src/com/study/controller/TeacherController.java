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
		System.out.println("测试bookService是否装配成功"+teacherService);
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
//		紧跟他的查询就是一个分页查询
		PageHelper.startPage(i, 10);
		List<Teacher> teachers = teacherService.getTeachers();
//		如果此时下面又来一句，那么这里显示的是全部而不是分页后的结果
//		List<Teacher> teachers = teacherService.getTeachers();
//		使用PageInfo对结果进行分页显示
//		PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
//		这个表示分页之后你希望连续展示多少页
		PageInfo<Teacher> pageInfo = new PageInfo<>(teachers, 10);
		System.out.println("当前页码:"+pageInfo.getPageNum());
		System.out.println("总页数:"+pageInfo.getPages());
		System.out.println("当前页有几条记录:"+pageInfo.getSize());
		System.out.println("总记录数:"+pageInfo.getTotal());
		System.out.println("上一页:"+pageInfo.getPrePage());
		System.out.println("下一页:"+pageInfo.getNextPage());
		System.out.println("最后一行:"+pageInfo.getEndRow());
		System.out.println("首行："+pageInfo.getStartRow());
		System.out.println("查询结果的类型："+pageInfo.getList());
//		把连续分页的页数整成一个数组保存
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		model.addAttribute("pageInfo", pageInfo);
		return "success";
	}
}
