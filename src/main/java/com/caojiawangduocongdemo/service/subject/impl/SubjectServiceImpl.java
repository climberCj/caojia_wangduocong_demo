/**
 * Copyright (c) 2019, 万维公司 All rights reserved.
 * 万维公司 专有/保密源代码,未经许可禁止任何人通过任何渠道使用、修改源代码.
 */
package com.caojiawangduocongdemo.service.subject.impl;

import com.caojiawangduocongdemo.dao.SubjectMapper;
import com.caojiawangduocongdemo.entity.Subject;
import com.caojiawangduocongdemo.service.subject.SubjectService;
import com.caojiawangduocongdemo.utils.ExamUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
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

    @Transactional
    @Override
    public int save(Subject subject) {
        if("".equals(subject.getStstatus()) || subject.getStstatus() == null){
            subject.setStstatus("1");
        }
        if("".equals(subject.getStno()) || subject.getStno() == null){
            List<String> stnoList = this.queryStnoList();
            String[] array = new String[stnoList.size()];
            array = stnoList.toArray(array);
            int maxNum = ExamUtils.getMax(array);
            subject.setStno(ExamUtils.getString(maxNum+1));
        }
        return subjectMapper.insertSelective(subject);
    }

    @Override
    public Subject findBySysId(String sysid) {
        return subjectMapper.selectByPrimaryKey(sysid);
    }

    @Override
    public List<String> queryStnoList() {
        return subjectMapper.getStnoList();
    }
}
