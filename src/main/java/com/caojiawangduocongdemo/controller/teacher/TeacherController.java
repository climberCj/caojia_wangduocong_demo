package com.caojiawangduocongdemo.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author caojia
 * @createtime 2019-11-15 14:45
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @RequestMapping("/main")
    public String main(){
        return "teacher/teacher_index";
    }
}
