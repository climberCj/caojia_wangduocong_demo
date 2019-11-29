package com.caojiawangduocongdemo.controller.student;

import com.caojiawangduocongdemo.common.BizException;
import com.caojiawangduocongdemo.common.GlobalExceptionHandler;
import com.caojiawangduocongdemo.dao.StudentMapper;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.service.student.StudentService;
import com.caojiawangduocongdemo.utils.GsonHelper;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
   /* @Autowired
    private StudentMapper studentMapper;*/

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String view(HttpServletRequest request,
                       @RequestParam(value = "page",required = false,defaultValue = "1") int page,
                       @RequestParam(value = "pageSize",defaultValue = "20") int pageSize,
                       @RequestParam(value = "q",required = false) String q,
                       @RequestParam(value = "stuStatus", required = false,defaultValue = "1") String stuStatus,
                       @RequestParam(value = "studentId",required = false) String studentId,
                       @RequestParam(value = "studentName",required = false) String studentName,
                       @RequestParam(value = "sclass",required = false) String sclass) {
        request.setAttribute("result", studentService.sPage(page, pageSize, q,stuStatus));
        request.setAttribute("url", (null == q ? "" : "?q=" + q));
        request.setAttribute("students", studentService.getAll());
        request.setAttribute("stuStatus", stuStatus);
        request.setAttribute("sclass",studentService.findBysclass(sclass));
        request.setAttribute("studentById", studentService.findByStudentId(studentId));
        request.setAttribute("studentByName", studentService.findByName(studentName));
        return "student/stulist";
    }

/*    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<String> insert(HttpEntity<Student> body) {
        if (body.getBody() == null || body.getBody().getSysid() == null || body.getBody().getSysid().isEmpty() ||
                body.getBody().getStudentid() == null || body.getBody().getStudentid().isEmpty() ||
                body.getBody().getStudentname() == null || body.getBody().getStudentname().isEmpty()
                ) {
            throw new BizException("学号和姓名不能为空");
        } else if (studentMapper.countBySudentId(body.getBody().getStudentid()) > 0) {
            throw new BizException("该生已存在");
        }
        studentService.insert(body.getBody());
        return ResponseEntity.ok("{}");
    }*/

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String insert(){

       return "student/addExam";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String > save(@RequestParam(value = "studentId",required = false)String studentId,
                                        @RequestParam(value = "sysid",required = false)String sysid,
                                        @RequestParam(value = "studentName",required = false)String studentName,
                                        @RequestParam(value = "sclass",required = false)String sclass,
                                        @RequestParam(value = "result",required = false)int result,
                                        @RequestParam(value = "stupic ",required = false)String stupic,
                                        @RequestParam(value = "teacherId",required = false)String teacherId){
        studentService.insert( sysid, studentId, studentName, sclass, stupic, result, teacherId);
        return ResponseEntity.ok("{}");
    }
    @RequestMapping(value = "/student/{sysid}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("sysid") String sysid,
                                         @RequestParam("sclass") String sclass,
                                         @RequestParam("result") int result,
                                         @RequestParam("stupic") String stupic) {
        studentService.updateBySysid(sysid, sclass, stupic, result);
        return ResponseEntity.ok("{}");
    }

    @RequestMapping(value = "/student/{sysid}/stuStatus", method = RequestMethod.PUT)
    public ResponseEntity<String> delete(@PathVariable("sysid") String sysid) {
        studentService.updateStatus(sysid);
        return ResponseEntity.ok("{}");

    }
    /*@RequestMapping(value = "/student/sclass",method = RequestMethod.GET)
    public ResponseEntity<String> findByClass( @RequestParam("sclass") String sclass){
        return ResponseEntity.ok().body(GsonHelper.DEFAULT_GSON.toJson(studentService.findBysclass(sclass)));
    }*/

}
