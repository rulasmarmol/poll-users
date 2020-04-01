package nbn.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nbn.entities.APICall;
import nbn.scheduled.PollUsers;

@RestController
public class Poll{

    @Autowired
    public PollUsers pollUsers;

    @GetMapping("/poll")
    public APICall poll(@RequestParam(value="id", defaultValue = "1") String id){
        pollUsers.setId(id);
        pollUsers.setIsPollEnabled(true);
        return new APICall("poll",LocalDateTime.now(),"200",pollUsers.getRequest(),"");
    }
}










