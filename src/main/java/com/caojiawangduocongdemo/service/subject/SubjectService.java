package com.caojiawangduocongdemo.service.subject;

import com.caojiawangduocongdemo.entity.Score;
import com.caojiawangduocongdemo.entity.Subject;
import com.github.pagehelper.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface SubjectService {
    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示条数
     * @return
     */
    Page<Subject> findByPage(Map<String,Object> conditions,int pageNo, int pageSize);

    int save(Subject subject);

    Subject findBySysId(String sysid);

    List<String> queryStnoList();

    int delete(String sysid);

    List<Subject> findAll();

    int getScore(HttpServletRequest request,List<String> selects,List<String> prim);

    void save(HttpServletRequest request,int score);
}
