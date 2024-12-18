package com.smp.thread.service;

import com.smp.thread.entity.MessageEntity;
import com.smp.thread.exception.MessageServiceException;
import com.smp.thread.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    private static final int BATCH_SIZE = 100;
    private static final long SLEEP_DURATION = 200;

    public void insertMessages() {
        while (!Thread.currentThread().isInterrupted()) {
            List<MessageEntity> messages = new ArrayList<>();
            for (int i = 0; i < BATCH_SIZE; i++) {
                MessageEntity message = new MessageEntity();
                message.setMessage("Message " + (i + 1));
                messages.add(message);
            }
            try {
                messageRepository.saveAll(messages);
            } catch (RuntimeException e) {
                throw new MessageServiceException("Ошибка при сохранении сообщений", e);
            }
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
            }
        }
    }

    public void countMessages() {
        while (!Thread.currentThread().isInterrupted()) {
            long count = messageRepository.count();
            log.info("Количество записей в таблице: {}", count);
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

