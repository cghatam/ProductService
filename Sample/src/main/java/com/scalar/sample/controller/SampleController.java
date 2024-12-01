package com.scalar.sample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scalar.sample.dto.SendEmailMessageDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public SampleController(KafkaTemplate<String, String> kafkaTemplate,
                            ObjectMapper objectMapper){
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }


    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return "Hello " + name;
    }

    @PostMapping("/signIn")
    public SendEmailMessageDto signIn(@RequestBody SendEmailMessageDto sendEmailMessageDto){
        try{
            String message = objectMapper.writeValueAsString(sendEmailMessageDto);
            kafkaTemplate.send("sendEmail", message);
            System.out.println("Send success, message : " + message);

        }catch (Exception e){
            System.out.println(e.toString());
        }

        return sendEmailMessageDto;
    }

}
