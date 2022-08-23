package com.caojiawangduocongdemo.service.transaction.impl;

import com.caojiawangduocongdemo.dao.SalaryMapper;
import com.caojiawangduocongdemo.entity.Salary;
import com.caojiawangduocongdemo.service.transaction.LisiTransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @PackageName:com.caojiawangduocongdemo.service.transaction.impl
 * @ClassName:LisiTransactionalServiceImpl
 * @Description:
 * @Author:caojia
 * @Date:2022/7/2310:48
 */
@Service
public class LisiTransactionalServiceImpl implements LisiTransactionalService {

    @Autowired
    private SalaryMapper salaryMapper;

    /**
     * 李四加上100
     * @param salary
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transferToRequired(Salary salary) {
        Salary salaryL = salaryMapper.queryByKey(salary.getSalaryId());
        BigDecimal b1 = salaryL.getMoney();
        BigDecimal b2 = b1.add(new BigDecimal("100"));
        salaryL.setMoney(b2);
        salaryMapper.updateByPrimaryKey(salaryL);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transferToRequiredException(Salary salary) {
        Salary salaryL = salaryMapper.queryByKey(salary.getSalaryId());
        BigDecimal b1 = salaryL.getMoney();
        BigDecimal b2 = b1.add(new BigDecimal("100"));
        salaryL.setMoney(b2);
        salaryMapper.updateByPrimaryKey(salaryL);
        // 模拟异常
        int sum = 100/0;
    }
}
