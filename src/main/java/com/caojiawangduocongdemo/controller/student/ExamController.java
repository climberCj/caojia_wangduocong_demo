package com.caojiawangduocongdemo.controller.student;

import com.caojiawangduocongdemo.common.ResultBody;
import com.caojiawangduocongdemo.entity.Score;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.entity.Subject;
import com.caojiawangduocongdemo.service.score.ScoreService;
import com.caojiawangduocongdemo.service.subject.SubjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private ScoreService scoreService;

    @RequiresPermissions("exam")
    @RequestMapping("/index")
    public String goToExam(HttpServletRequest request, Model model){
        Student stu = (Student)request.getSession().getAttribute("user");
        Score score = scoreService.findLastScore(stu.getStudentid());
        model.addAttribute("s",score.getScore());
        return "exam_main";
    }

    @RequiresPermissions("exam")
    @RequestMapping("/online")
    public String goToExam(Model model,HttpServletRequest request){
        Student stu = (Student)request.getSession().getAttribute("user");
        Score score = scoreService.findLastScore(stu.getStudentid());
        model.addAttribute("s",score.getScore());
        List<Subject> subjectList = subjectService.findAll();
        model.addAttribute("lists", subjectList);
        return "student/exam";
    }

    @RequiresPermissions("exam")
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
        //将试题主键的集合存放到session中，以便后面查看试卷解析调用
        HttpSession session = request.getSession();
        session.setAttribute("stKey", primaryKey);
        int score = subjectService.getScore(request,examAnswers,primaryKey);
        return ResultBody.success(score);
    }

    @RequiresPermissions("view")
    @RequestMapping("/score")
    public String getScore(String studentid,Model model){
        Score score = scoreService.findLastScore(studentid);
        model.addAttribute("score", score.getScore());
        return "student/view_score";
    }

    @RequiresPermissions("view")
    @RequestMapping("/parse")
    public String getAnswer(HttpServletRequest request,Model model) {
        List<Subject> lists = new ArrayList<>();
        //为了保证查看解析的题目是试卷题目，之前得到试卷后，将题目主键存放到session中，方便在此调用
        List<String> st = (List<String>)request.getSession().getAttribute("stKey");
        for(int i = 0;i<st.size();i++){
            //通过主键查询试题
            Subject sub = subjectService.findBySysId(st.get(i));
            lists.add(sub);
        }
        model.addAttribute("stKey",lists);
        return "student/view_parse";
    }
}
