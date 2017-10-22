package com.flowable.listener;

import org.flowable.task.service.delegate.DelegateTask;

public class TaskListener implements org.flowable.engine.delegate.TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("Task name:" + delegateTask.getName());
        switch (delegateTask.getTaskDefinitionKey()) {
            case "classifyTask":
                delegateTask.setAssignee("classifier");
                break;
            case "processLevel1":
                delegateTask.setAssignee("processLevel1");
                break;
            case "processLevel2":
                delegateTask.setAssignee("processLevel2");
                break;
            case "processLevel3":
                delegateTask.setAssignee("processLevel3");
                break;
            default:
                break;
        }
        System.out.println("New assignee:" + delegateTask.getAssignee());
    }
}
