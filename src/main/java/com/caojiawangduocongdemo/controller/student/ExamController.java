package com.caojiawangduocongdemo.controller.student;

import com.caojiawangduocongdemo.common.ResultBody;
import com.caojiawangduocongdemo.entity.Subject;
import com.caojiawangduocongdemo.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @RequestMapping("/doSubmit")
    @ResponseBody
    public ResultBody commit(HttpServletRequest request){
        //定义一个存放每个试题被选答案的容器 可以使用Map以试题主键为Key,选择的答案为value
        List<String> examAnswers = new ArrayList<>();
        //存放每一个试题的主键
        List<String> primaryKey = new ArrayList<>();
        for(int i = 0;i < 5;i ++){
            String answer = request.getParameter("stanswer"+i);
            examAnswers.add(answer);
            String examIndex = request.getParameter("sysid"+i);
            primaryKey.add(examIndex);
        }
        int score = subjectService.getScore(examAnswers,primaryKey);
        return ResultBody.success(score);
    }
}
