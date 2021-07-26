package com.caojiawangduocongdemo.service.subject.impl;

import com.caojiawangduocongdemo.common.BizException;
import com.caojiawangduocongdemo.dao.ScoreMapper;
import com.caojiawangduocongdemo.dao.SubjectMapper;
import com.caojiawangduocongdemo.entity.Score;
import com.caojiawangduocongdemo.entity.Student;
import com.caojiawangduocongdemo.entity.Subject;
import com.caojiawangduocongdemo.service.subject.SubjectService;
import com.caojiawangduocongdemo.utils.ExamUtils;
import com.caojiawangduocongdemo.utils.TimeUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.MapUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author caojia
 * @createtime 2019-11-21 17:54
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public Page<Subject> findByPage(Map<String,Object> conditions,int pageNo, int pageSize) {
        Page<Subject> page = PageHelper.startPage(pageNo,pageSize);
        return subjectMapper.findByPage(conditions);
    }

    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(String sysid) {
        Subject subject = subjectMapper.selectByPrimaryKey(sysid);
        if(subject==null){
            throw new BizException("该对象不存在");
        }
        subject.setStstatus("0");
        return subjectMapper.updateByPrimaryKeySelective(subject);
    }

    @Override
    public List<Subject> findAll() {
        List<Subject> lists = subjectMapper.findAll();
        List<Subject> examLists = new ArrayList<>();
        if(lists.size()<5){
            return lists;
        }else{
            //从所有试题中选出5道题组成试卷
            for(int i = 0;i < 5;i ++){
                Random r = new Random();
                int a = r.nextInt(lists.size());
                examLists.add(lists.get(a));
                lists.remove(a);
            }
            return examLists;
        }
    }

    @Override
    public int getScore(HttpServletRequest request,List<String> selects,List<String> prim) {
        int score = 0;
        if(CollectionUtils.isEmpty(selects)&&CollectionUtils.isEmpty(prim)){
            throw new BizException("成绩获取异常");
        }else{
            //使用List的有序特性
            for(int i =0;i < prim.size();i ++){
                String rightAnswer = this.findBySysId(prim.get(i)).getStanswer();
                if(rightAnswer.equals(selects.get(i))){
                    score += 20;
                }
            }
            //将成绩保存进score表中
            save(request,score);
        }
        return score;
    }

    @Transactional
    @Override
    public void save(HttpServletRequest request, int score) {
        Student student = (Student) request.getSession().getAttribute("user");
        Score s = new Score();
        s.setStudentid(student.getStudentid());
        s.setScore(score);
        s.setSubmittime(TimeUtil.getCurrentTime());
        int res = scoreMapper.insertSelective(s);
        if(res!=1){
            throw new BizException("分数保存失败");
        }
    }
}
