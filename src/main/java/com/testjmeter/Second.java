package com.testjmeter;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ license : (C) Copyright 2013-2019, SanGuo Information Technology Co., Ltd.
 * @ Author  : TimWang
 * @ FileName: Second.java
 * @ Time    : 2020/2/22 14:45
 * @ Software: IntelliJ IDEA
 */
public class Second  implements JavaSamplerClient {
    //URLName 就是在图形化界面当中显示的变量名称
    private static final String URLName = "URL";

    //设置界面当中默认显示的变量的值
    private static final String DEFAULT_URL = "http://www.baidu.com";
    /**
     * 这个方法决定了在jmeter当中要显示哪些属性
     * @return arguments
     */

    //用来存储响应的数据，目的是将响应结果放到察看结果树当中
    private String resultData;

    public Arguments getDefaultParameters() {
        System.out.println("getDefaultParameters run");
        Arguments arguments = new Arguments();
        arguments.addArgument(URLName,DEFAULT_URL);
        return arguments;
    }

    private String inputUrl;
    /**
     * 这个方法就是一个初始化方法，我们所有的初始化的动作都可以在这里写
     * @param javaSamplerContext
     */
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        inputUrl = javaSamplerContext.getParameter(URLName,DEFAULT_URL);
        System.out.println("setupTest run");
        System.out.println("用户输入的url地址是:"+inputUrl);
    }

    /**
     * 这个方法就是实现你具体功能逻辑的方法
     * @param javaSamplerContext
     * @return
     */
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

        SampleResult result = new SampleResult();
        System.out.println("runTest run");
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(inputUrl);

            URLConnection conn = url.openConnection();

            byte[] buffer = new byte[1024];
            int len;
            result.sampleStart();//标记事务的开始，统计数据
            InputStream inputStream = conn.getInputStream();
            while ((len=inputStream.read(buffer))!=-1){
                resultData = new String(buffer,"UTF-8");
                sb.append(resultData);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        resultData = "这就是响应结果:";
        resultData = sb.toString();
        result.setSampleLabel("自定义java访问请求");
        result.setSuccessful(true);//告诉察看结果数访问是否成功
        result.setResponseData(resultData,null);
        result.setDataType(SampleResult.TEXT);
        return result;
    }

    /**
     * 这个方法就是来做一个收尾的工作的
     * @param javaSamplerContext
     */
    public void teardownTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("teardownTest run");
    }

}
