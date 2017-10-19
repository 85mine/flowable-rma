package com.flowable.web.controller.api.task.list;

import com.flowable.service.FlowableService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListController {


    @Autowired
    FlowableService flowableService;

    public ListController() {

    }

    @CrossOrigin(origins = "http://bpmn.com")
    @GetMapping(value = "/api/v1/task/list", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<Task> Execute(@RequestBody Object object) {
        List<Task> tasks = flowableService.getTasks(object);
        return tasks;
    }
}
