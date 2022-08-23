package com.caojiawangduocongdemo.service.transaction.impl;

import com.caojiawangduocongdemo.entity.Salary;
import com.caojiawangduocongdemo.service.transaction.LisiTransactionalService;
import com.caojiawangduocongdemo.service.transaction.TransactionalService;
import com.caojiawangduocongdemo.service.transaction.ZhangsanTransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PackageName:com.caojiawangduocongdemo.service.transaction.impl
 * @ClassName:TransactionalServiceImpl
 * @Description:
 * @Author:caojia
 * @Date:2022/7/2312:01
 */
@Service
public class TransactionalServiceImpl implements TransactionalService {

    @Autowired
    private ZhangsanTransactionalService zhangsanTransactionalService;

    @Autowired
    private LisiTransactionalService lisiTransactionalService;

    /**
     * 外围方法没有开启事务，且嵌套方法，也就是内部方法使用required传播机制
     */
    @Override
    public void notransaction_transfer_required_required(Salary salary) {
        zhangsanTransactionalService.transferFromRequired(salary);

        Salary salary1 = new Salary();
        salary1.setSalaryId(2);
        lisiTransactionalService.transferToRequired(salary1);

        throw new NullPointerException();
    }

    @Override
    public void notransaction_transfer_required_required_exception(Salary salary) {
        zhangsanTransactionalService.transferFromRequired(salary);

        Salary salary1 = new Salary();
        salary1.setSalaryId(2);
        lisiTransactionalService.transferToRequiredException(salary1);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_transfer_required_required(Salary salary) {
        zhangsanTransactionalService.transferFromRequired(salary);

        Salary salary1 = new Salary();
        salary1.setSalaryId(2);
        lisiTransactionalService.transferToRequired(salary1);

        throw new NullPointerException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_transfer_required_required_exception(Salary salary) {
        zhangsanTransactionalService.transferFromRequired(salary);

        Salary salary1 = new Salary();
        salary1.setSalaryId(2);
        lisiTransactionalService.transferToRequiredException(salary1);
    }

    @Override
    public void transaction_transfer_required_required_exception_try(Salary salary) {
        zhangsanTransactionalService.transferFromRequired(salary);
        try {
            Salary salary1 = new Salary();
            salary1.setSalaryId(2);
            lisiTransactionalService.transferToRequiredException(salary1);
        }catch (Exception e){
            System.out.println("发生异常，方法回滚");
        }
    }
}
