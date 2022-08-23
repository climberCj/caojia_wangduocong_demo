package com.caojiawangduocongdemo.service.transaction;

import com.caojiawangduocongdemo.entity.Salary;

public interface TransactionalService2 {
    void transferFrom(Salary salary);

    void transferTo(Salary salary);
}
