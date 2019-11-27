package com.caojiawangduocongdemo.controller.student;

import com.caojiawangduocongdemo.entity.Subject;
import com.caojiawangduocongdemo.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author caojia
 * @createtime 2019-11-27 16:36
 */
@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/index")
    public String goToExam(Model model){
        List<Subject> subjectList = subjectService.findAll();
        model.addAttribute("lists", subjectList);
        return "student/exam";
    }
}
