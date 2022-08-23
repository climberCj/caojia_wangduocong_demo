package com.caojiawangduocongdemo.dao;

import com.caojiawangduocongdemo.entity.Salary;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryMapper {
    int updateByPrimaryKey(Salary salary);

    Salary queryByKey(Integer salaryId);
}
