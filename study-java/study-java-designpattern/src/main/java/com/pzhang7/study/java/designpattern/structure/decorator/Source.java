package com.pzhang7.study.java.designpattern.structure.decorator;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
