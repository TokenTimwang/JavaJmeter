package com.functions;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ license : (C) Copyright 2013-2019, SanGuo Information Technology Co., Ltd.
 * @ Author  : TimWang
 * @ FileName: Plus.java
 * @ Time    : 2020/2/22 16:14
 * @ Software: IntelliJ IDEA
 */
public class Plus extends AbstractFunction {

    /**
     * 执行方法
     * @ param sampleResult
     * @ param sampler
     * @ return
     * @ throws InvalidVariableException
     */

    private Object[] values;
    private CompoundVariable first,second;//存储第一个参数和第二个参数

    public String execute(SampleResult sampleResult, Sampler sampler) throws InvalidVariableException {
        System.out.println("execute run!!!");

        first = (CompoundVariable) values[0];
        System.out.println("第一个参数:"+first);
        second = (CompoundVariable) values[1];
        System.out.println("第二个参数:"+second);

        int count = new Integer(first.execute().trim()) + new Integer((second.execute().trim()));
        System.out.println("两数相加的和是:"+count);
        return String.valueOf(count);
    }

    /**
     * 设置参数，接收用户传递的参数
     * @ param collection
     * @ throws InvalidVariableException
     */
    public void setParameters(Collection<CompoundVariable> collection) throws InvalidVariableException {
        checkMinParameterCount(collection,2);
        values = collection.toArray();

        System.out.println("setParameters run!!!");
    }

    /**
     * 功能名称
     * @ return __MyDemo
     */
    public String getReferenceKey() {
        System.out.println("getReferenceKey run!!!");
        return "__MyDemoPlus";
    }

    /**
     *功能描述，参数描述
     * @ return desc
     */
    public List<String> getArgumentDesc() {
        System.out.println("getArgumentDesc run!!!");
        List desc = new ArrayList();
        desc.add("第一个数字");
        desc.add("第二个数字");

        return desc;
    }
}
