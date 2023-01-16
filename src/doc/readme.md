
[B站课程地址](https://www.bilibili.com/video/BV1H54y167gf/?p=13&spm_id_from=333.788.top_right_bar_window_history.content.click&vd_source=dd9e0d42756c3d61df99de756c651fb9)

# service

## RuntimeService
## TaskService
## HistoryService
## ManagementService




# activiti 入门操作
**创建一个activiti工作流，主要包括以下几步**
- 定义流程
> 按照BPMN规范，使用流程定义工具，用流程符号把整个流程描述出来
-  部署流程
> 把画好的流程定义文件，加载到数据库中，生成表的数据
-  启动流程
> 使用java代码来操作数据库表中的内容 

-----

流程定义部署：
1. 使用流程设计器，流程符号，画出流程图。  
    bpmn,png文件  
    都是流程资源文件，用来描述流程，流程中需要的节点，节点负责人。  
    如出差申请流程、请假申请流程、报销申请流程等
    
2. 把流程的资源文件进行部署。  
    上传到数据库中，使用java代码来进行部署。  
    一次部署操作：  
        ACT_RE_DEPLOYMENT 会生成一条记录  
        ACT_RE_PROCDEF 生成流程定义信息  
        
3. deployment 和 procdef表，一对多的关系。  
    在procdef表中，可以有多条记录，每条记录对应一个流程的定义信息。  
    张三  出差申请  
    李四 出差申请
    
    
            
   
       