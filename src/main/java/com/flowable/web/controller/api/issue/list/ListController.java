package com.flowable.web.controller.api.issue.list;

import com.flowable.service.FlowableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {


    @Autowired
    FlowableService flowableService;

    public ListController() {

    }

    @CrossOrigin(origins = "http://bpmn.com")
    @GetMapping(value = "/api/v1/issue/list", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String Execute() {
        return null;
    }
}
