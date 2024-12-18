package com.smp.thread;

import com.smp.thread.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private MessageService messageService;

    @Override
    public void run(String... args) throws InterruptedException {

        Thread insertThread = new Thread(() -> messageService.insertMessages());
        insertThread.start();

        Thread countThread = new Thread(() -> messageService.countMessages());
        countThread.start();

        insertThread.join();
        countThread.join();
    }
}
