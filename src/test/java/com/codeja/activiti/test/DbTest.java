package com.codeja.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class DbTest {

    /**
     * 初始化25个表
     * @param
     */
    @Test
    public  void aaa() {

        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        System.out.println("defaultProcessEngine = " + defaultProcessEngine);
    }
}

