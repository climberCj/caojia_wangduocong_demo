package com.caojiawangduocongdemo.controller.student;

import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.service.student.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author caojia
 * @time 下午 10:10
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/main")
    public String main(){
        return "student_index";
    }
}
