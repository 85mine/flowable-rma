package com.flowable.service;

import com.flowable.entity.Group;
import com.flowable.entity.Issue;
import com.flowable.entity.User;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public ProcessInstance startProcess(Issue issue) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("issue", issue);
        return runtimeService.startProcessInstanceByKey("oneTaskProcess", variables);
    }

    public List<Task> getTasks(Object assignee) {
        if (assignee instanceof User) {
            return taskService.createTaskQuery().taskAssignee(((User) assignee).getUserName()).list();
        }

        if (assignee instanceof Group) {
            return taskService.createTaskQuery().taskCandidateGroup(((Group) assignee).getGroupName()).list();
        }
        return null;
    }
}
