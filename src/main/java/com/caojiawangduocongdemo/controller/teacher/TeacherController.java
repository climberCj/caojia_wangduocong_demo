package com.caojiawangduocongdemo.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author caojia
 * @createtime 2019-11-15 14:45
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    //@Resource(name = "demo")
    //private com.climber.climberspringbootstarter.service.DemoService demoService;

    @RequestMapping("/main")
    public String main(HttpServletRequest request,Model model){
        //Teacher teacher = (Teacher)request.getSession().getAttribute("user");
        return "teacher/teacher_index";
    }
}
