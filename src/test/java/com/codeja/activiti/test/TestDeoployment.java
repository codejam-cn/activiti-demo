package com.codeja.activiti.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

import java.util.List;

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


    /**
     * 启动流程实例
     * act_hi_actinst
     * act_hi_identitylink
     * act_hi_procinst  流程实例的历史信息
     * act_hi_taskinst  任务的历史信息
     * act_ru_execution 流程执行信息
     * act_ru_identitylink  流程参与者信息
     * act_ru_task 任务信息
     */
    @Test
    public void testStartProcess() {

        //1. 创建ProcessEngine

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2. 获取RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //3. 根据流程的id启动流程
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("myEvection");

        //4.输出内容
        System.out.println("instance.getProcessDefinitionId() = " + instance.getProcessDefinitionId());

        System.out.println("instance.getId() = " + instance.getId());

        System.out.println("instance.getActivityId() = " + instance.getActivityId());
    }


    /**
     * 查询个人待执行的任务
     */
    @Test
    public void testFindPersonTaskList() {

        //1.获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.获取taskService
        TaskService taskService = processEngine.getTaskService();


        //3.根据key和任务的负责人，查询任务
        List<Task> aaa = taskService.createTaskQuery()
                .processDefinitionKey("aaa")
                .taskAssignee("")
                .list();

        //4. 输出
        for (Task task : aaa) {
            System.out.println("task.getProcessInstanceId() = " + task.getProcessInstanceId());
            System.out.println("task.getId() = " + task.getId());
            System.out.println("task.getAssignee() = " + task.getAssignee());
            System.out.println("task.getName() = " + task.getName());
        }
    }

}
