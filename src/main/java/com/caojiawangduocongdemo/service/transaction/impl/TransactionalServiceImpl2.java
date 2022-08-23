package com.caojiawangduocongdemo.service.transaction.impl;

import com.caojiawangduocongdemo.dao.SalaryMapper;
import com.caojiawangduocongdemo.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @PackageName:com.caojiawangduocongdemo.service.transaction.impl
 * @ClassName:TransactionalServiceImpl2
 * @Description:
 * @Author:caojia
 * @Date:2022/7/2316:49
 */
@Service
public class TransactionalServiceImpl2 /*implements TransactionalService2*/ {

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    @Lazy
    private TransactionalServiceImpl2 transactionalServiceImpl2;

    @Transactional
    public void transferFrom(Salary salary) {
        Salary salaryZ = salaryMapper.queryByKey(salary.getSalaryId());
        BigDecimal b1 = salaryZ.getMoney();
        BigDecimal b2 = b1.subtract(new BigDecimal("100"));
        salaryZ.setMoney(b2);
        salaryMapper.updateByPrimaryKey(salaryZ);

        Salary salaryL = new Salary();
        salaryL.setSalaryId(2);
        // 使用异常进行捕获是为了将transferTo方法发生的异常进行屏蔽，针对方法transferFrom来说，感知不到，
        try{
            // 调用B方法
            // 注意：这种写法肯定是有问题的，spring aop的特性，这种写法 transferTo() 不会被当前类的代理对象进行调用，因此，肯定使用不到事务
            //transferTo(salaryL);
            transactionalServiceImpl2.transferTo(salary);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void transferTo(Salary salary) {
        Salary salaryL = salaryMapper.queryByKey(salary.getSalaryId());
        BigDecimal b1 = salaryL.getMoney();
        BigDecimal b2 = b1.add(new BigDecimal("100"));
        salaryL.setMoney(b2);
        int sum = 100/0;
        salaryMapper.updateByPrimaryKey(salaryL);
    }
}
