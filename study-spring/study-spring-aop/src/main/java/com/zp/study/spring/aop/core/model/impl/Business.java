package com.zp.study.spring.aop.core.model.impl;

import com.zp.study.spring.aop.core.model.IBusiness;
import com.zp.study.spring.aop.core.model.IBusiness2;

/**
 * 业务逻辑类
 */
public class Business implements IBusiness, IBusiness2 {

    public static void main(String[] args) {
        Business h = new Business();
        h.doSomeThing2();
        h.doSomeThing();
    }

    @Override
    public boolean doSomeThing() {
        System.out.println("执行业务逻辑");
        return true;
    }

    @Override
    public void doSomeThing2() {
        String s = "执行业务逻辑2";
        System.out.println(s);
    }

}