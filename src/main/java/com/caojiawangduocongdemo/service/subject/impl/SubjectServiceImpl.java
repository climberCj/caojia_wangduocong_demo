/**
 * Copyright (c) 2019, 万维公司 All rights reserved.
 * 万维公司 专有/保密源代码,未经许可禁止任何人通过任何渠道使用、修改源代码.
 */
package com.caojiawangduocongdemo.service.subject.impl;

import com.caojiawangduocongdemo.dao.SubjectMapper;
import com.caojiawangduocongdemo.entity.Subject;
import com.caojiawangduocongdemo.service.subject.SubjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author caojia
 * @createtime 2019-11-21 17:54
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Override
    public Page<Subject> findByPage(Map<String,Object> conditions,int pageNo, int pageSize) {
        Page<Subject> page = PageHelper.startPage(pageNo,pageSize);
        return subjectMapper.findByPage(conditions);
    }

    @Override
    public int save(Subject subject) {
        return subjectMapper.insertSelective(subject);
    }

    @Override
    public Subject findBySysId(String sysid) {
        return subjectMapper.selectByPrimaryKey(sysid);
    }
}
