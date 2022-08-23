package com.caojiawangduocongdemo.service.transaction;

import com.caojiawangduocongdemo.entity.Salary;

/**
 * @PackageName:com.caojiawangduocongdemo.service.transaction
 * @ClassName:TransactionalService
 * @Description:
 * @Author:caojia
 * @Date:2022/7/2310:47
 */
public interface ZhangsanTransactionalService {

    /**
     * 转账起始方
     * @param salary
     */
    void transferFromRequired(Salary salary);

    void transferFromException(Salary salary);
}
