package com.codeja.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class Test2 {

    /**
     * @param
     */
    @Test
    public void aaa() {

        //使用自定义方式

        /** 1. 配置文件可以自定义
         *
         */
        ProcessEngineConfiguration engineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");

        //2.得到流程引擎
        ProcessEngine processEngine = engineConfiguration.buildProcessEngine();

        System.out.println("processEngine = " + processEngine);
    }
}

