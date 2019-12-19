package com.caojiawangduocongdemo.controller.subject;

import com.caojiawangduocongdemo.common.BizException;
import com.caojiawangduocongdemo.common.ResultBody;
import com.caojiawangduocongdemo.entity.Subject;
import com.caojiawangduocongdemo.service.subject.SubjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author caojia
 * @createtime 2019-11-21 17:48
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    /**
     * 试题分页列表
     * @param pageNo
     * @param pageSize
     * @param request
     * @param model
     * @return
     */
    @RequiresPermissions("query")
    @RequestMapping("/list")
    public String findPage(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo,
                           @RequestParam(value = "pageSize",defaultValue = "5")int pageSize, HttpServletRequest request, Model model){
        //存放查询条件的Map集合，查询条件的name前缀必须为filter_
        Map<String,Object> searchParams = Servlets.getParametersStartingWith(request,"filter_");
        Page<Subject> page = subjectService.findByPage(searchParams,pageNo,pageSize);
        PageInfo<Subject> pageInfo = new PageInfo<>(page);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("searchParams",Servlets.encodeParameterStringWithPrefix(searchParams,"filter_"));
        //用于前台回显
        Map<String,Object> params = new HashMap<>();
        for(Map.Entry<String,Object> entry:searchParams.entrySet()){
            params.put(entry.getKey(),entry.getValue());
        }
        model.addAttribute("sParams",params);
        return "subject/subject_list";
    }

    /**
     * 跳转添加试题页面
     * @return
     */
    @RequiresPermissions("create")
    @RequestMapping("/addExam")
    public String addQues(String sysid, Model model){
        Subject subject = null;
        if(StringUtils.isEmpty(sysid)){
            subject = new Subject();
        }else{
            subject = subjectService.findBySysId(sysid);
        }
        model.addAttribute("subject", subject);
        return "subject/addExam";
    }

    @RequiresPermissions("update")
    @RequestMapping("/save")
    @ResponseBody
    public ResultBody saveSubject(Subject subject){
        if(subject == null){
            throw new BizException("试题对象为空");
        }
        int result = subjectService.save(subject);
        return ResultBody.success(result);
    }

    @RequiresPermissions("delete")
    @RequestMapping("/delete")
    @ResponseBody
    public ResultBody delete(String sysid){
        int result = subjectService.delete(sysid);
        if(result != 1){
            throw new BizException("删除失败！");
        }
        return ResultBody.success(result);
    }
}
