package com.caojiawangduocongdemo.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author caojia
 * @createtime 2019-11-27 16:36
 */
@Controller
@RequestMapping("/exam")
public class ExamController {

    @RequestMapping("/index")
    public String goToExam(){
        return "student/exam";
    }
}
