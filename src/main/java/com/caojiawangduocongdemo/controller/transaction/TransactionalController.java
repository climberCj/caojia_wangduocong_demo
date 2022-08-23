package com.caojiawangduocongdemo.controller.transaction;

import com.caojiawangduocongdemo.entity.Salary;
import com.caojiawangduocongdemo.service.transaction.TransactionalService;
import com.caojiawangduocongdemo.service.transaction.impl.TransactionalServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:com.caojiawangduocongdemo.controller.transaction
 * @ClassName:TransactionalController
 * @Description: 用于测试事务的传播机制
 * @Author:caojia
 * @Date:2022/7/2310:40
 */
@RestController
public class TransactionalController {

    @Autowired
    private TransactionalService transactionalService;

    @Autowired
    private TransactionalServiceImpl2 transactionalService2;

    @RequestMapping("transfer/test")
    public String transfer(Integer salaryId){
        Salary salary = new Salary();
        salary.setSalaryId(salaryId);
        // 1.1、外围方法没有开启事务，内部方法开启了事务且传播机制为 required
        // 结论：外围方法没有开启事务，张三李四的转账业务操作均在自己的事务中独立运行，外围方法的异常不会影响内部方法的执行
        //transactionalService.notransaction_transfer_required_required(salary);
        // 1.2、外围方法没有开启事务，内部方法开启了事务且传播机制为 required 但是其中一个发生了异常
        // 结论：外围方法没有开启事务，张三李四的转账业务操作均在自己的事务中独立运行，所以只是回滚了发生异常的内部方法的事务操作，而另外一个不受影响
        // 1整体结论：外围方法未开启事务的情况下，REQUIRED修饰的内部方法会新开启自己的事务，且开启的事务相互独立，互不干扰
        //transactionalService.notransaction_transfer_required_required_exception(salary);
        //2.1、外围方法开启事务，内部方法加入外围方法事务，外围方法回滚，内部方法也要回滚
        //transactionalService.transaction_transfer_required_required(salary);
        //2.2、外围方法开启事务，内部方法加入外围方法事务，内部方法抛出异常回滚，外围方法感知到异常致使整个事务回滚
        //transactionalService.transaction_transfer_required_required_exception(salary);
        //2.3、外围方法开启事务，内部方法加入外围方法事务，内部方法抛出异常回滚，即使方法被catch不被外围方法感知到，整个事务依然回滚
        //2在外围方法开启事务的情况下，REQUIRED修饰的内部方法会加入到外围方法的事务中，所有REQUIRED修饰的内部方法和外围方法均属于同一事务，只要一个方法回滚，整个事务军回滚
        //transactionalService.transaction_transfer_required_required_exception_try(salary);


        return "张三给李四转账成功";
    }

    @RequestMapping("transfer2/test")
    public String transfer2(Integer salaryId){
        Salary salary = new Salary();
        salary.setSalaryId(salaryId);
        transactionalService2.transferFrom(salary);
        return "张三给李四转账成功";
    }

}
