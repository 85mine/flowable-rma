package com.flowable.web.controller.api.issue.create;

import com.flowable.entity.Issue;
import com.flowable.service.FlowableService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateController {


    @Autowired
    FlowableService flowableService;

    public CreateController() {

    }

    @CrossOrigin(origins = "http://bpmn.com")
    @PostMapping(value = "/api/v1/issue/create", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String Execute(@RequestBody Issue issue) {
        ProcessInstance processInstance = flowableService.startProcess(issue);
        return "success";
    }
}
