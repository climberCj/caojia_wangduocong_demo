package com.caojiawangduocongdemo.service.subject;

import com.caojiawangduocongdemo.entity.Subject;
import com.github.pagehelper.Page;

public interface SubjectService {
    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示条数
     * @return
     */
    Page<Subject> findByPage(int pageNo, int pageSize);

    int save(Subject subject);

    Subject findBySysId(String sysid);
}
