package com.testjmeter;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * @ license : (C) Copyright 2013-2019, SanGuo Information Technology Co., Ltd.
 * @ Author  : TimWang
 * @ FileName: First.java
 * @ Time    : 2020/2/22 14:12
 * @ Software: IntelliJ IDEA
 */
public class First extends AbstractJavaSamplerClient {

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

        System.out.println("hello jmeter!!!!");
        return null;

    }
}
