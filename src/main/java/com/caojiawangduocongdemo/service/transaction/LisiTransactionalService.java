package com.caojiawangduocongdemo.service.transaction;

import com.caojiawangduocongdemo.entity.Salary;

/**
 * @PackageName:com.caojiawangduocongdemo.service.transaction
 * @ClassName:TransactionalService
 * @Description:
 * @Author:caojia
 * @Date:2022/7/2310:47
 */
public interface LisiTransactionalService {
    /**
     * 转账终止方
     * @param salary
     */
    void transferToRequired(Salary salary);

    void transferToRequiredException(Salary salary);
}
