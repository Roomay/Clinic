package com.dzqc.cloud.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class IndicatorService {
    private Logger LOG = LoggerFactory.getLogger(IndicatorService.class);

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    public IndicatorService(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "#{kafkaTopicName}", groupId = "#{topicGroupId}")
    public void processMessage(ConsumerRecord<Integer, String> record) {
        LOG.info("kafka processMessage start");
        LOG.info("processMessage, topic = {}, msg = {}", record.topic(), record.value());

        // 消息处理（如发送给Engine等）

        LOG.info("kafka processMessage end");
    }

    public void sendMessage(String topic, String data) {
        LOG.info("kafka sendMessage start");
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, data);
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                LOG.error("kafka sendMessage error, exception = {}, topic = {}, data = {}", throwable, topic, data);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {
                LOG.info("kafka sendMessage success topic = {}, data = {}", topic, data);
            }
        });
        LOG.info("kafka sendMessage end");
    }
}
