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
        System.out.println(studentService.sPage(page, pageSize, q,stuStatus).getList());
        request.setAttribute("url", (null == q ? "" : "?q=" + q));
        request.setAttribute("students", studentMapper.findAll());
        request.setAttribute("stuStatus", stuStatus);
        request.setAttribute("sclass",studentService.findBysclass(sclass));
        request.setAttribute("studentById", studentService.findByStudentId(studentId));
        request.setAttribute("studentByName", studentService.findByName(studentName));
        return "student/stulist";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<String> insert(HttpEntity<Student> body) {
        if (body.getBody() == null || body.getBody().getSysid() == null || body.getBody().getSysid().isEmpty() ||
                body.getBody().getStudentid() == null || body.getBody().getStudentid().isEmpty() ||
                body.getBody().getStudentname() == null || body.getBody().getStudentname().isEmpty()
                ) {
            throw new BizException("学号和姓名不能为空");
        } else if (studentMapper.countBySudentId(body.getBody().getStudentid()) > 0) {
            throw new BizException("该生已存在");
        } else if (body.getBody().getStuStatus() == "0" || body.getBody().getStuStatus() == null || body.getBody().getStuStatus().isEmpty()) {
            throw new BizException("请检查学生状态");
        }
        studentMapper.insert(body.getBody());
        return ResponseEntity.ok("{}");
//        return "student/";
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
