package com.caojiawangduocongdemo.controller.student;

import com.alibaba.fastjson.JSON;
import com.caojiawangduocongdemo.common.BizException;
import com.caojiawangduocongdemo.common.GlobalExceptionHandler;
import com.caojiawangduocongdemo.dao.StudentMapper;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.service.student.StudentService;
import com.caojiawangduocongdemo.utils.GsonHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

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

    @RequiresPermissions("query")
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String view(HttpServletRequest request,
                       @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                       @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                       @RequestParam(value = "q", required = false) String q,
                       @RequestParam(value = "stuStatus", required = false, defaultValue = "1") String stuStatus,
                       @RequestParam(value = "studentId", required = false) String studentId,
                       @RequestParam(value = "studentName", required = false) String studentName,
                       @RequestParam(value = "sclass", required = false) String sclass) {
        request.setAttribute("result", studentService.sPage(page, pageSize, q, stuStatus));
        request.setAttribute("url", (null == q ? "" : "?q=" + q));
        request.setAttribute("students", studentService.getAll());
        request.setAttribute("stuStatus", stuStatus);
        request.setAttribute("sclass", studentService.findBysclass(sclass));
        request.setAttribute("studentById", studentService.findByStudentId(studentId));
        request.setAttribute("studentByName", studentService.findByName(studentName));
        return "student/stulist";
    }

    @RequiresPermissions("create")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> save(Student student) {
        studentService.save(student);
        return ResponseEntity.ok("{}");
    }

    @RequiresPermissions("query")
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<String> up(@PathVariable("id") String id, Student student) {

        studentService.updateBySysid(id,student);
        return ResponseEntity.ok("");
    }

    @RequiresPermissions("create")
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String insert(HttpServletRequest request, Student student) {

        request.setAttribute("addStudent", student);
        return "student/addExam";
    }

    @RequiresPermissions("create")
    @RequestMapping(value = "/student/{sysid}/stuStatus", method = RequestMethod.PUT)
    public ResponseEntity<String> delete(@PathVariable("sysid") String sysid) {
        studentService.updateStatus(sysid);
        return ResponseEntity.ok("{}");

    }

    @RequiresPermissions("query")
    @RequestMapping(value = "/student/sclass", method = RequestMethod.GET)
    public ResponseEntity<String> findByClass(@RequestParam("sclass") String sclass) {
        return ResponseEntity.ok().body(GsonHelper.DEFAULT_GSON.toJson(studentService.findBysclass(sclass)));
    }

}
