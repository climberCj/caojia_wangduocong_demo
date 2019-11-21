package com.caojiawangduocongdemo.controller.subject;

import com.caojiawangduocongdemo.entity.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author caojia
 * @createtime 2019-11-21 17:48
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {
    /**
     * 学生分页列表
     * @param pageNo
     * @param pageSize
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String findPage(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                           @RequestParam(value = "pageSize",defaultValue = "5")int pageSize, HttpServletRequest request, Model model){
        Page<Student> page = studentService.findByPage(pageNo,pageSize);
        PageInfo<Student> pageInfo = new PageInfo<>(page);
        model.addAttribute("pageInfo",pageInfo);
        return "student/stulist";
    }
}
