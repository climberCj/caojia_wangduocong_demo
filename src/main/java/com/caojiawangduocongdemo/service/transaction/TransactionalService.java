package com.caojiawangduocongdemo.service.transaction;

import com.caojiawangduocongdemo.entity.Salary;

public interface TransactionalService {
    /**
     * 外围方法没有开启事务，内部方法使用required
     * @param salary
     */
    void notransaction_transfer_required_required(Salary salary);

    /**
     * 外围方法没有开启事务，内部方式使用了 required 但是其中一个内部方法中发生了异常
     * @param salary
     */
    void notransaction_transfer_required_required_exception(Salary salary);

    /**
     * 外围方法开启事务，内部方法使用required
     * @param salary
     */
    void transaction_transfer_required_required(Salary salary);

    /**
     * 外围方法开启事务，内部方式使用了 required 但是其中一个内部方法中发生了异常
     * @param salary
     */
    void transaction_transfer_required_required_exception(Salary salary);

    /**
     * 外围方法开启事务，内部方式使用了 required 但是其中一个内部方法中发生了异常，使用了try catch捕获，使得外围方法感知不到
     * @param salary
     */
    void transaction_transfer_required_required_exception_try(Salary salary);

}
