package com.caojiawangduocongdemo.controller.student;

import com.caojiawangduocongdemo.common.BizException;
import com.caojiawangduocongdemo.common.GlobalExceptionHandler;
import com.caojiawangduocongdemo.dao.StudentMapper;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author caojia
 * @time 下午 10:10
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping(value = "/students",method = RequestMethod.GET)
    public String view(HttpServletRequest request,
                       @RequestParam("page")int page,
                       @RequestParam("pageSize")int pageSize,
                       @RequestParam("q")String q,
                       @RequestParam(value = "status",defaultValue = "1")String status,
                       @RequestParam("studentId")String studentId,
                       @RequestParam("studentName")String studentName,
                       @RequestParam("sclass")String sclass){
        request.setAttribute("result",studentService.sPage(page, pageSize, q,status));
        request.setAttribute("url", (null == q ? "" : "?q=" + q));
        request.setAttribute("students",studentMapper.findAll());
        request.setAttribute("status",status);
        request.setAttribute("studentById",studentService.findByStudentId(studentId));
        request.setAttribute("studentByName",studentService.findByName(studentName));
        request.setAttribute("studentSclass",studentService.findBysclass(sclass));
        return "student/stulist";
    }
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public ResponseEntity<String> insert(HttpEntity<Student> body){
        if (body.getBody()==null||body.getBody().getSysid()==null||body.getBody().getSysid().isEmpty()||
                body.getBody().getStudentid()==null||body.getBody().getStudentid().isEmpty()||
                body.getBody().getStudentname()==null||body.getBody().getStudentname().isEmpty()
                ){
            throw new BizException("学号和姓名不能为空");
        }else if (studentMapper.countBySudentId(body.getBody().getStudentid())>0){
            throw new BizException("该生已存在");
        }else if (body.getBody().getStustatus()=="0"||body.getBody().getStustatus()==null||body.getBody().getStustatus().isEmpty()){
            throw new BizException("请检查学生状态");
        }
        return ResponseEntity.ok("{}");
    }
    @RequestMapping(value = "/student/{sysid}",method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("sysid")String sysid,
                                         @RequestParam("sclass")String  sclass,
                                         @RequestParam("result")int result,
                                         @RequestParam("stupic")String stupic){
        studentService.updateBySysid(sysid,sclass,stupic,result);
       return ResponseEntity.ok("{}");
       }
       @RequestMapping(value = "/student/{sysid}/status",method = RequestMethod.PUT)
    public ResponseEntity<String> delete(@PathVariable("sysid")String sysid,
                                         @RequestParam("status")String status){
        studentService.updateStatus(sysid,status);
        return ResponseEntity.ok("{}");

       }
}
