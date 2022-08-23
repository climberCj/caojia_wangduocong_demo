package com.caojiawangduocongdemo.entity;

import java.math.BigDecimal;

/**
 * @PackageName:com.caojiawangduocongdemo.entity
 * @ClassName:Salary
 * @Description:
 * @Author:caojia
 * @Date:2022/7/2310:50
 */
public class Salary {
    private Integer salaryId;
    private String cardId;
    private BigDecimal money;
    private String userNm;

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }
}
