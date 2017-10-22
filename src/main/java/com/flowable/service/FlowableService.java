package com.flowable.service;

import com.google.gson.Gson;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class FlowableService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    public boolean startProcess(Map<String, Object> params) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("barcode", params.get("barcode"));
        variables.put("order_id", params.get("order_id"));
        variables.put("apartment_id", params.get("apartment_id"));
        variables.put("product_id", params.get("product_id"));
        variables.put("drawer_id", params.get("drawer_id"));
        variables.put("accessories_id", params.get("accessories_id"));
        variables.put("issue_type", params.get("issue_type"));
        variables.put("issue_type_description", params.get("issue_type_description"));
        variables.put("issue_level", params.get("issue_level"));
        variables.put("issue_level_description", params.get("issue_level_description"));
        System.out.println("Start process: " + variables);
        runtimeService.startProcessInstanceByKey("autoProcess", variables);
        return true;
    }

    public String getTasks(String assignee) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();
        List<Map<String, Object>> listTaskVariables = new ArrayList<>();
        for (Task task : tasks
                ) {
            Map<String, Object> variables = new HashMap<>();
            variables.put("task_id", task.getId());
            variables.put("task_name", task.getName());
            variables.put("assignee", task.getAssignee());
            variables.put("parent_task_id", task.getParentTaskId());
            variables.put("process_definition_id", task.getProcessDefinitionId());
            variables.put("process_instance_id", task.getProcessInstanceId());
            listTaskVariables.add(variables);
        }
        System.out.println("Get tasks: " + listTaskVariables);
        return new Gson().toJson(listTaskVariables);
    }

    public boolean completeTask(String taskId, Map<String, Object> params) {
        if (params.size() == 0) {
            taskService.complete(taskId);
        } else {
            taskService.complete(taskId, params);
        }
        return true;
    }

    public boolean completeTask(String taskId) {
        taskService.complete(taskId);
        return true;
    }
}
