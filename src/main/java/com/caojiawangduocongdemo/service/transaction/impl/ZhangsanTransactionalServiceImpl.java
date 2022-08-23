package com.caojiawangduocongdemo.service.transaction.impl;

import com.caojiawangduocongdemo.dao.SalaryMapper;
import com.caojiawangduocongdemo.entity.Salary;
import com.caojiawangduocongdemo.service.transaction.ZhangsanTransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @PackageName:com.caojiawangduocongdemo.service.transaction
 * @ClassName:ZhangsanTransactionalServiceImpl
 * @Description: 模拟张三向李四转账200元
 * @Author:caojia
 * @Date:2022/7/2310:47
 */
@Service
public class ZhangsanTransactionalServiceImpl implements ZhangsanTransactionalService {

    @Autowired
    private SalaryMapper salaryMapper;

    /**
     * 张三减去100
     * @param salary
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transferFromRequired(Salary salary) {
        Salary salaryZ = salaryMapper.queryByKey(salary.getSalaryId());
        BigDecimal b1 = salaryZ.getMoney();
        BigDecimal b2 = b1.subtract(new BigDecimal("100"));
        salaryZ.setMoney(b2);
        salaryMapper.updateByPrimaryKey(salaryZ);
    }

    @Override
    public void transferFromException(Salary salary) {

    }
}
