package com.scalar.sample.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async
    public void asyncMethodWithVoidReturn(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("-----------------------------------");
        System.out.println("Executed method with void return type asynchronously");
    }

    @Async
    public CompletableFuture<String> asyncMethodWithReturn(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("-----------------------------------");
        return CompletableFuture.completedFuture("Hello from async method!");

    }






}
