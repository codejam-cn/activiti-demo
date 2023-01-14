package com.codeja.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;

public class TestDeoployment {


    /**
     * 部署
     */
    @Test
    public void testDeployment() {

        //1.创建ProcessEngine
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();


        //2. 获取 RepositoryService

        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();


        //3. 使用service，来进行流程的部署, 定义一个流程名字，把 bpmn和png部署到数据库中

        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();

        Deployment leave = deploymentBuilder.name("出差申请流程")
                .addClasspathResource("bpmn/leave.bpmn")
                //.addClasspathResource()
                .deploy();


        //4.（非必须）输出部署信息

        System.out.println("leave.getId() = " + leave.getId());
        System.out.println("leave.getName() = " + leave.getName());
        System.out.println("leave.getCategory() = " + leave.getCategory());

    }
}
