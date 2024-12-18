package com.scalar.sample.controller;

import com.scalar.sample.service.AsyncService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
public class AsyncController {

    AsyncService asyncService;

    @GetMapping("/asyncVoid")
    public String asyncVoid(){
        System.out.println("-----------------------------------Before Async void call");
        asyncService.asyncMethodWithVoidReturn();
        System.out.println("-----------------------------------After Async void call");
        return "Request to async void method has been made";
    }

    @GetMapping("/asyncReturn")
    public CompletableFuture<String> asyncReturn(){
        System.out.println("-----------------------------------Before Async call");

        CompletableFuture<String> completableFuture =  asyncService.asyncMethodWithReturn();
        System.out.println("-----------------------------------Additional activities");
        return completableFuture;

    }

}
