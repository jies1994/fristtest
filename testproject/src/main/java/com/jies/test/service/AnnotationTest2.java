package com.jies.test.service;

/**
 * Created by peijie on 17/4/14.
 */
public class AnnotationTest2 {

    @AnnotationTest1(value = "yes value")
    private String testStr;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public static void main(String [] args){
        System.out.println(new AnnotationTest2().getTestStr());
    }
}
