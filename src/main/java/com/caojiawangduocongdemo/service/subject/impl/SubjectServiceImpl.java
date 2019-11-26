/**
 * Copyright (c) 2019, 万维公司 All rights reserved.
 * 万维公司 专有/保密源代码,未经许可禁止任何人通过任何渠道使用、修改源代码.
 */
package com.caojiawangduocongdemo.service.subject.impl;

import com.caojiawangduocongdemo.common.BizException;
import com.caojiawangduocongdemo.dao.SubjectMapper;
import com.caojiawangduocongdemo.entity.Subject;
import com.caojiawangduocongdemo.service.subject.SubjectService;
import com.caojiawangduocongdemo.utils.ExamUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
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
        Subject exitsSub = subjectMapper.selectByPrimaryKey(subject.getSysid());
        if(exitsSub!=null){//说明存在，更新数据
           return subjectMapper.updateByPrimaryKeySelective(subject);
        }else{
            if("".equals(subject.getStstatus()) || subject.getStstatus() == null){
                subject.setStstatus("1");
            }
            if("".equals(subject.getStno()) || subject.getStno() == null){
                List<String> stnoList = this.queryStnoList();
                //由于数据库中查出来的数据有为Null的情况，因此移除集合中的Null
                stnoList.removeAll(Collections.singleton(null));
                if(!CollectionUtils.isEmpty(stnoList) && stnoList.size()!=0){
                    String[] array = new String[stnoList.size()];
                    array = stnoList.toArray(array);
                    int maxNum = ExamUtils.getMax(array);
                    subject.setStno(ExamUtils.getString(maxNum+1));
                }else{
                    subject.setStno("1");
                }
            }
            return subjectMapper.insertSelective(subject);
        }
    }

    @Override
    public Subject findBySysId(String sysid) {
        return subjectMapper.selectByPrimaryKey(sysid);
    }

    @Override
    public List<String> queryStnoList() {
        return subjectMapper.getStnoList();
    }

    @Override
    @Transactional
    public int delete(String sysid) {
        Subject subject = subjectMapper.selectByPrimaryKey(sysid);
        if(subject==null){
            throw new BizException("该对象不存在");
        }
        subject.setStstatus("0");
        return subjectMapper.updateByPrimaryKeySelective(subject);
    }
}
