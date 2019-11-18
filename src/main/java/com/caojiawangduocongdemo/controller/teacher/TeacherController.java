package com.caojiawangduocongdemo.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author caojia
 * @time 下午 10:08
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @RequestMapping("/main")
    public String main(){
        return "teacher/teacher_index";
    }
}
