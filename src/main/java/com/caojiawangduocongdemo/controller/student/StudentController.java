package com.caojiawangduocongdemo.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
